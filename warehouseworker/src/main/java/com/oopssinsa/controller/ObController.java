package com.oopssinsa.controller;

import com.oopssinsa.model.dto.*;
import com.oopssinsa.model.service.LocationService;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.model.service.StockService;
import com.oopssinsa.view.ObInstructionView;

import java.time.LocalDate;
import java.util.List;

public class ObController {
    private String workerId=null;
    ObService obService = new ObService();
    StockService stockService = new StockService();
    ObInstructionView obView = new ObInstructionView();
    LocationService locationService = new LocationService();

    public void setWorkerId(String id){
        this.workerId = id;
    }
    public void getObInstructionToDo() {
        List<ObInstructionDto> obInstructions = obService.getObInstructionToDo(this.workerId);
        if(obInstructions!=null){
            ObInstructionView.displayObInstructions(obInstructions);
        }
        else{
            System.out.println("출고 지시 목록 오류 발생");
        }
    }

    public void updateObStatus(){
        long obInstructionId =-1;
        String productId = null;
        LocalDate manufactureId = null;
        String updateStatus = obView.inputUpdateObInstructionStatus(obInstructionId, productId, manufactureId);
        int trackingNumber = (int)(Math.random()*100000)+1;
        ObDto updateOb = new ObDto(obInstructionId, manufactureId, productId, 0,LocalDate.now(),updateStatus,trackingNumber);
        //
        obService.updateObStatus(updateOb);


        //출고 처리 결과가 성공이면 재고 현황 및 재고 내역에 반영
        if(updateStatus=="S"){
            ObDto foundOb = obService.findOb(new ObDto(obInstructionId,manufactureId,productId,0,null,null,0));
            IbInstructionDto foundIbInstruction = obService.findObInstruction(new IbInstructionDto(obInstructionId, manufactureId,productId,this.workerId,0));
            StockDto foundStock = stockService.findStock(new StockDto(productId,manufactureId,0,0,0));
            long locationId = foundIbInstruction.getLocationId();
            int originalCapacity = locationService.getCurrentCapacity(locationId);
            // 예진 작업 시작
            int productVolume = obService.findProductVolume(foundStock.getProductId());
            int updateCapacity;
            // 예진 작업 끝
            if(foundOb!=null && foundStock!=null){
                int updateQuantity = foundOb.getQuantity();
                int originalQuantity = foundStock.getQuantity();
                int expectedQuantity = foundStock.getExpected_quantity();
                updateCapacity = productVolume * updateQuantity;
                stockService.updateStock(new StockDto(productId,manufactureId, 0,
                        originalQuantity-updateQuantity,expectedQuantity-updateQuantity));
                stockService.insertStockHistory(new StockHistoryDto(manufactureId, productId, updateQuantity, LocalDate.now()));
                // 예진 작업 시작
                locationService.updateCurrentCapacity(new SubLocationDto(locationId,originalCapacity-updateCapacity,+updateCapacity));
                // 예진 작업 끝
            }

        }
    }
}
