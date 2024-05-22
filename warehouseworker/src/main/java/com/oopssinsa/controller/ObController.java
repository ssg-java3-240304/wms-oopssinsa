package com.oopssinsa.controller;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.service.LocationService;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.model.service.SectionService;
import com.oopssinsa.model.service.StockService;
import com.oopssinsa.view.ObInstructionView;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ObController {
    private String workerId=null;
    ObService obService = new ObService();
    StockService stockService = new StockService();
    SectionService sectionService = new SectionService();
    ObInstructionView obView = new ObInstructionView();
    LocationService locationService = new LocationService();

    public void setWorkerId(String id){
        this.workerId = id;
    }
    public void getObInstructionToDo() {
        List<ObInstructionDto> obInstructions = obService.getObInstructionToDo(this.workerId);
        if(obInstructions!=null){
            obView.displayObInstructions(obInstructions);
        }
        else{
            System.out.println("출고 지시 목록 오류 발생");
        }
    }

    public void updateObStatus(){
        String[] obInfo = new String[3];
        String updateStatus = obView.inputUpdateObInstructionStatus(obInfo); // 작업자가 입력한 상태값
        long obInstructionId =Integer.parseInt(obInfo[0]); // 작업자가 입력한 작업한 복합키 값
        String productId = obInfo[1];
        LocalDate manufactureId = LocalDate.parse(obInfo[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Integer trackingNumber = null;
        if (updateStatus.equals("S")){
            trackingNumber = obService.findTrackingNumber(obInstructionId);
            if (trackingNumber == null) {
                trackingNumber = (int)(Math.random()*100000)+1;
                obService.insertTrackingNumber(obInstructionId, trackingNumber);
            }
        }
        ObDto updateOb = new ObDto(obInstructionId, manufactureId, productId, 0,LocalDate.now(),updateStatus,trackingNumber);
        obService.updateObStatus(updateOb);


        //출고 처리 결과가 성공이면 재고 현황 및 재고 내역에 반영
        if(updateStatus.equals("S")){
            ObDto foundOb = obService.findOb(new ObDto(obInstructionId,manufactureId,productId,0,null,updateStatus,0));
            ObInstructionDto foundObInstruction = obService.findObInstruction(new ObInstructionDto(obInstructionId, manufactureId,productId,this.workerId));
            StockDto foundStock = stockService.findStock(new StockDto(productId,manufactureId,0,0,0));
//            long locationId = foundObInstruction.getLocationId();
            long locationId = obService.findProductLocation(foundOb.getProductId());
            int originalCapacity = locationService.getCurrentCapacity(locationId);
            // 예진 작업 시작
            int productVolume = obService.findProductVolume(productId);
            int updateCapacity;
            // 예진 작업 끝
            if(foundOb!=null && foundStock!=null){
                int updateQuantity = foundOb.getQuantity();
                int originalQuantity = foundStock.getQuantity();
                int expectedQuantity = foundStock.getExpectedQuantity();
                updateCapacity = productVolume * updateQuantity;
                stockService.updateStock(new StockDto(productId,manufactureId, 0,
                        (originalQuantity-updateQuantity),(expectedQuantity+updateQuantity)));
                System.out.printf("""
                        ==========================================================================
                        재고 업데이트 성공.
                        상품ID : %s
                        제조일자(LOT) : %s
                        출고 후 수량 : %d
                        ---------------------------------------------------------------------------
                        """, productId, manufactureId, originalQuantity-updateQuantity);
                stockService.insertStockHistory(new StockHistoryDto(manufactureId, productId, -updateQuantity, LocalDate.now()));
                System.out.printf("""
                        재고 내역 업데이트 성공.
                        상품ID : %s
                        제조일자(LOT) : %s
                        변동수량 : %d
                        """,productId, manufactureId, -updateQuantity);
                System.out.println("출고일자 : " + LocalDate.now());
                System.out.println("---------------------------------------------------------------------------");
                // 예진 작업 시작
                locationService.updateCurrentCapacity(new SubLocationDto(locationId,(originalCapacity-updateCapacity),+updateCapacity));
                // 예진 작업 끝
                System.out.printf("""
                        위치 적치 용량 업데이트 성공.
                        Location %d
                        출고 후 용량 : %d
                        ==========================================================================
                        """,  locationId, originalCapacity-updateCapacity);
                sectionService.updateSectionCurrentCapacity(locationId);
            }
        }
    }
}
