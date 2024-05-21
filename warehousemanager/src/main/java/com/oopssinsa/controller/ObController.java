package com.oopssinsa.controller;

import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.ObDetailDto;
import com.oopssinsa.model.dto.ObRequestAndStockDto;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.WorkerDto;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.model.service.WorkerService;
import com.oopssinsa.view.ErrorView;
import com.oopssinsa.view.InputView;
import com.oopssinsa.view.ObView;
import com.oopssinsa.view.WorkerView;
import java.util.ArrayList;
import java.util.List;

public class ObController {
    private final ObService obService;
    private final ObView obView;
    private final WorkerService workerService;
    private final WorkerView workerView;
    private final InputView inputView;
    private final ErrorView errorView;

    public ObController() {
        this.obService = new ObService();
        this.obView = new ObView();
        this.workerService = new WorkerService();
        this.workerView = new WorkerView();
        this.inputView = new InputView();
        this.errorView = new ErrorView();
    }

    public void findObByRequestState() {
        obView.printObRequestState(obService.findObByRequestState());
    }

    public void findAllOb() {
        obView.printAllOb(obService.findAllOb());
    }

    public void updateState() {
        List<ObRequestAndStockDto> obRequestAndStock = obService.findObRequestAndStock();
        obView.printObRequestAndStock(obRequestAndStock);
        int index = inputView.getNumber() - 1;
        ObRequestAndStockDto selectedOb = null;
        try {
            selectedOb = obRequestAndStock.get(index);
        } catch (IndexOutOfBoundsException e) {
            errorView.printError("없는 번호 입니다.");
            return;
        }
        if (selectedOb.getObStatus() == 'F') {
            obView.printImpossibleOb();
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
                            selectedOb.getProductId(), stockDto.getQuantity(), 'W', selectedOb.getObDate(),
                            null, null));

                    // 재고 예정 수량 업데이트
                    stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + stockDto.getQuantity());
                    obService.updateStock(stockDto);

                } else if (count <= stockDto.getQuantity()) {
                    obDetailDtos.add(new ObDetailDto(stockDto.getManufactureDate(), selectedOb.getId(),
                            selectedOb.getProductId(), count, 'W', selectedOb.getObDate(),
                            null, null));
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

    public void insertObWorker() {
        List<ObDetailDto> obDetailDtos = obService.findObDetailByWaitingState();
        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();

        obView.printObDetail(obDetailDtos);
        workerView.printAssignableWorker(workerService.findWorkerByAssignableStatus());

        ObDetailDto selectedObDetailDto = null;
        WorkerDto selectedWorkerDto = null;
        try {
            selectedObDetailDto = obDetailDtos.get(obView.getObIndex());
            selectedWorkerDto = workerDtos.get(workerView.getWorkerIndex());
        } catch (IndexOutOfBoundsException e) {
            errorView.printError("없는 번호 입니다.");
            return;
        }

        // 지시테이블에 삽입
        workerService.insertIbWorker(new InstructionDto(selectedObDetailDto.getObId(), selectedObDetailDto.getManufactureDate(),
                selectedObDetailDto.getProductId(), selectedWorkerDto.getId()));

        // 출고테이블 상태 업데이트
        selectedObDetailDto.setStatus('P');
        obService.updateObState(selectedObDetailDto);

        // 작업자 상태 업데이트
        selectedWorkerDto.setStatus('F');
        workerService.updateWorkerStatus(selectedWorkerDto);

        System.out.println(selectedObDetailDto.getStatus());
        System.out.println(selectedWorkerDto.getStatus());
    }
}
