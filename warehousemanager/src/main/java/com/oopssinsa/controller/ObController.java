package com.oopssinsa.controller;

import com.oopssinsa.model.dto.ObDetailDto;
import com.oopssinsa.model.dto.ObRequestAndStockDto;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.view.InputView;
import com.oopssinsa.view.ObView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObController {

    private final ObService obService;
    private final ObView obView;
    private final InputView inputView;

    public ObController() {
        this.obService = new ObService();
        this.obView = new ObView();
        this.inputView = new InputView();
    }

    public void findObByRequestState() {
        obView.printObRequestState(obService.findObByRequestState());
    }

    public void findAllOb() {
        obView.printAllOb(obService.findAllOb());
    }

    public void updateState() {
        List<ObRequestAndStockDto> obRequestAndStock = obService.findObRequestAndStock();
        System.out.println("상태를 변경할 출고요청을 선택해주세요.");
        obView.printObRequestAndStock(obRequestAndStock);
        int index = inputView.getNumber() - 1;
        ObRequestAndStockDto selectedOb = null;
        try {
            selectedOb = obRequestAndStock.get(index);

        } catch (IndexOutOfBoundsException e) {
            System.err.println("없는 번호 입니다.");
            return;
        }
        if (selectedOb.getObStatus() == 'F') {
            System.out.println("해당 요청은 출고할 수 없습니다.");
            return;
        }
        if (selectedOb.getObStatus() == 'T') {
            List<StockDto> stockDtos = obService.findStockOrderableByProductId(
                    selectedOb.getProductId());
            List<ObDetailDto> obDetailDtos = new ArrayList<>();

            int count = selectedOb.getQuantity();
            for (StockDto stockDto : stockDtos) {
                if (count > stockDto.getQuantity()) {
                    count -= stockDto.getQuantity();
                    obDetailDtos.add(new ObDetailDto(stockDto.getManufactureDate(), selectedOb.getId(),
                            selectedOb.getProductId(), stockDto.getQuantity(), 'W', null, null));

                    // 재고 예정 수량 업데이트
                    stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + stockDto.getQuantity());
                    obService.updateStock(stockDto);

                } else if (count <= stockDto.getQuantity()) {
                    obDetailDtos.add(new ObDetailDto(stockDto.getManufactureDate(), selectedOb.getId(),
                            selectedOb.getProductId(), count, 'W', null, null));
                    // 재고 예정 수량 업데이트
                    stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + count);
                    obService.updateStock(stockDto);
                    break;
                }
            }
            // 삭제필요
            for (ObDetailDto obDetailDto : obDetailDtos) {
                System.out.println(obDetailDto.getObId() +" "+ obDetailDto.getStatus() + " "+obDetailDto.getQuantity()
                        + " "+obDetailDto.getManufactureDate() + " "+obDetailDto.getProductId());
            }

            // ob_detail에 삽입
            obService.insertObDetails(obDetailDtos);
        }
    }
}
