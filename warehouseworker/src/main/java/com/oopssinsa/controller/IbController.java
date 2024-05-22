package com.oopssinsa.controller;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.service.IbService;
import com.oopssinsa.model.service.LocationService;
import com.oopssinsa.model.service.SectionService;
import com.oopssinsa.model.service.StockService;
import com.oopssinsa.view.IbInstructionView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class IbController {
    private String workerId=null;
    IbService ibService = new IbService();
    StockService stockService = new StockService();
    SectionService sectionService = new SectionService();
    LocationService locationService = new LocationService();
    IbInstructionView ibInstructionView = new IbInstructionView();

    public void setWorkerId(String id){
        this.workerId =id;
    }

    public void getIbInstructionToDo(){
        List<IbInstructionDto> ibInstructions = ibService.getIbInstructionToDo(this.workerId);
        if(ibInstructions!=null){ // 지시가 있으면
            ibInstructionView.displayIbInstructions(ibInstructions);
        }
        else{
            System.out.println("입고 지시 목록 오류 발생");
        }
    }
    public void updateIbStatus(){

        //사용자에게 ib에 대한 정보를 받아올 배열
        String[] ibInfo = new String[3];

        //처리할 입고 내역을 찾을 id, 상품
        String updateStatus = ibInstructionView.inputUpdateIbInstructionStatus(ibInfo);
        long ibInstructionId = Integer.parseInt(ibInfo[0]);
        String productId = ibInfo[1];
        LocalDate manufactureId = LocalDate.parse(ibInfo[2], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //location id는 상태 업데이트와 관련 없으므로 0 전달
        IbDto updateIb = new IbDto(ibInstructionId, manufactureId, productId, 0, null,updateStatus);
        //재귀 쿼리로 해당 입고 요청 찾아 상태 업데이트
        ibService.updateIbStatus(updateIb);

        // 입고 처리 결과가 성공이면 재고 현황, 재고처리 내역, 구역별 용량 업데이트
        if(updateStatus.equals("S")){
            System.out.println("입고 성공 처리 진입");
            IbDto foundIb = ibService.findIb(new IbDto(ibInstructionId, manufactureId, productId, 0,null,updateStatus));
//            IbInstructionDto foundIbInstruction = ibService.findIbInstruction(new IbInstructionDto(ibInstructionId, manufactureId,productId,this.workerId));
            StockDto foundStock = stockService.findStock(new StockDto(productId, manufactureId, 0,0,0));
            int updateQuantity; // 입고 요청의 수량
            int originalQuantity; // 원래 재고 수량
            int expectedQuantity; // 원래 재고 예정 수량(작업 예정 수량)
//            long locationId = foundIbInstruction.getLocationId();
            long locationId = ibService.findProductLocation(productId);

            if (foundStock == null) {
                originalQuantity = 0;
                expectedQuantity = foundIb.getQuantity();
                stockService.insertStock(new StockDto(productId, manufactureId, locationId,0,expectedQuantity));
                foundStock = stockService.findStock(new StockDto(productId, manufactureId, 0,0,0));
            }

            int originalCapacity = locationService.getCurrentCapacity(locationId);
            int productVolume = ibService.findProductVolume(productId);
            int updateCapacity;
            if(foundIb!=null && foundStock!=null){
                updateQuantity = foundIb.getQuantity(); // 요청된 입고 수량
                originalQuantity = foundStock.getQuantity(); // 현재 재고에 있는 수량
                expectedQuantity = foundStock.getExpectedQuantity(); // 입고 대기에서 예정된 수량
                updateCapacity = productVolume * updateQuantity; // 요청된 용량

                stockService.updateStock(new StockDto(productId, manufactureId, 0, (originalQuantity+updateQuantity),
                        (expectedQuantity-updateQuantity)));
                System.out.printf("""
                        ==========================================================================
                        재고 업데이트 성공.
                        상품ID : %s
                        제조일자(LOT) : %s
                        입고 후 수량 : %d
                        ---------------------------------------------------------------------------
                        """, productId, manufactureId, originalQuantity+updateQuantity);
                StockHistoryDto stockHistoryDto = new StockHistoryDto(manufactureId,productId,updateQuantity,LocalDate.now());
                stockService.insertStockHistory(stockHistoryDto);
                System.out.printf("""
                        재고 내역 업데이트 성공.
                        상품ID : %s
                        제조일자(LOT) : %s
                        변동수량 : %d
                        """,productId, manufactureId, updateQuantity);
                System.out.println("입고일자 : " + LocalDate.now());
                System.out.println("---------------------------------------------------------------------------");
                locationService.updateCurrentCapacity(new SubLocationDto(locationId,(originalCapacity+updateCapacity), -updateCapacity));
                System.out.printf("""
                        위치 적치 용량 업데이트 성공.
                        Location %d
                        입고 후 용량 : %d
                        ==========================================================================
                        """, locationId, originalCapacity+updateCapacity);
                sectionService.updateSectionCurrentCapacity(locationId);
            }
        }

    }
}
