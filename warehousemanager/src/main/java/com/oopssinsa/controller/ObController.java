package com.oopssinsa.controller;

import com.oopssinsa.model.constants.Error;
import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.WorkerDto;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.model.service.WorkerService;
import com.oopssinsa.view.ErrorView;
import com.oopssinsa.view.ObView;
import com.oopssinsa.view.WorkerView;

import java.util.ArrayList;
import java.util.List;

public class ObController {
    private final ObService obService;
    private final ObView obView;
    private final WorkerService workerService;
    private final WorkerView workerView;
    private final ErrorView errorView;

    public ObController() {
        this.obService = new ObService();
        this.obView = new ObView();
        this.workerService = new WorkerService();
        this.workerView = new WorkerView();
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
        ObRequestAndStockDto selectedOb = selectRequestOb(obRequestAndStock);

        if (selectedOb == null) {
            return;
        }

        if (selectedOb.getObStatus() == 'F') {
            obView.printImpossibleOb();
            return;
        }
        if (selectedOb.getObStatus() == 'T') {
            processOrderableOb(selectedOb);
        }
    }

    public void insertObWorker() {
        List<ObDetailDto> obDetailDtos = obService.findObDetailByWaitingState();
        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();
        obView.printObDetail(obDetailDtos);
        workerView.printAssignableWorker(workerDtos);

        try {
            ObDetailDto selectedObDetailDto = selectObDetailDto(obDetailDtos);
            WorkerDto selectedWorkerDto = selectWorkerDto(workerDtos);
            processInsertObWorker(selectedObDetailDto, selectedWorkerDto);
        } catch (IndexOutOfBoundsException e) {
            errorView.printError(Error.NON_EXISTENT_NUMBER_ERROR);
        }
    }

    private ObRequestAndStockDto selectRequestOb(List<ObRequestAndStockDto> obRequestAndStock) {
        ObRequestAndStockDto selectedOb = null;
        try {
            selectedOb = obRequestAndStock.get(obView.getChangeObIndex());
        } catch (IndexOutOfBoundsException e) {
            errorView.printError(Error.NON_EXISTENT_NUMBER_ERROR);
        }
        return selectedOb;
    }

    private ObDetailDto createObDetail(ObRequestAndStockDto selectedOb, StockDto stockDto, int quantity) {
        return new ObDetailDto(
                stockDto.getManufactureDate(),
                selectedOb.getId(),
                selectedOb.getProductId(),
                quantity,
                'W',
                selectedOb.getObDate(),
                null,
                null);
    }

    private void updateStockExpectedQuantity(StockDto stockDto, int requestQuantity) {
        stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + requestQuantity);
        obService.updateStock(stockDto);
    }

    private void insertObDetails(List<ObDetailDto> obDetailDtos) {
        obService.insertObDetails(obDetailDtos);
    }

    private void processOrderableOb(ObRequestAndStockDto selectedOb) {
        List<StockDto> stockDtos = obService.findStockOrderableByProductId(selectedOb.getProductId());
        List<ObDetailDto> obDetailDtos = new ArrayList<>();
        int requestQuantity = selectedOb.getQuantity();

        for (StockDto stockDto : stockDtos) {
            if (requestQuantity > stockDto.getQuantity()) {
                requestQuantity -= stockDto.getQuantity();
                obDetailDtos.add(createObDetail(selectedOb, stockDto, stockDto.getQuantity()));
                updateStockExpectedQuantity(stockDto, stockDto.getQuantity());
            } else {
                obDetailDtos.add(createObDetail(selectedOb, stockDto, requestQuantity));
                updateStockExpectedQuantity(stockDto, stockDto.getQuantity());
                break;
            }
        }

        insertObDetails(obDetailDtos);
    }


    private void processInsertObWorker(ObDetailDto selectedObDetailDto, WorkerDto selectedWorkerDto) {
        insertInstruction(selectedObDetailDto, selectedWorkerDto);
        updateObDetailStateToProgress(selectedObDetailDto);
        updateWorkerStatusToFalse(selectedWorkerDto);
    }

    private ObDetailDto selectObDetailDto(List<ObDetailDto> obDetailDtos) {
        return obDetailDtos.get(obView.getObIndex());
    }

    private WorkerDto selectWorkerDto(List<WorkerDto> workerDtos) {
        return workerDtos.get(workerView.getWorkerIndex());
    }

    private void insertInstruction(ObDetailDto selectedObDetailDto, WorkerDto selectedWorkerDto) {
        workerService.insertIbWorker(new InstructionDto(
                selectedObDetailDto.getObId(),
                selectedObDetailDto.getManufactureDate(),
                selectedObDetailDto.getProductId(),
                selectedWorkerDto.getId()
        ));
    }

    private void updateObDetailStateToProgress(ObDetailDto selectedObDetailDto) {
        selectedObDetailDto.setStatus('P');
        obService.updateObState(selectedObDetailDto);
    }

    private void updateWorkerStatusToFalse(WorkerDto selectedWorkerDto) {
        selectedWorkerDto.setStatus('F');
        workerService.updateWorkerStatus(selectedWorkerDto);
    }

//    public void updateState() {
//        List<ObRequestAndStockDto> obRequestAndStock = obService.findObRequestAndStock();
//        obView.printObRequestAndStock(obRequestAndStock);
//
//
//        ObRequestAndStockDto selectedOb = null;
//        try {
//            selectedOb = obRequestAndStock.get(obView.getChangeObIndex());
//        } catch (IndexOutOfBoundsException e) {
//            errorView.printError("없는 번호 입니다.");
//            return;
//        }
//        if (selectedOb.getObStatus() == 'F') {
//            obView.printImpossibleOb();
//            return;
//        }
//        if (selectedOb.getObStatus() == 'T') {
//            List<StockDto> stockDtos = obService.findStockOrderableByProductId(
//                    selectedOb.getProductId());
//            List<ObDetailDto> obDetailDtos = new ArrayList<>();
//
//            int count = selectedOb.getQuantity();
//            for (StockDto stockDto : stockDtos) {
//                if (count > stockDto.getQuantity()) {
//                    count -= stockDto.getQuantity();
//                    obDetailDtos.add(new ObDetailDto(stockDto.getManufactureDate(), selectedOb.getId(),
//                            selectedOb.getProductId(), stockDto.getQuantity(), 'W', selectedOb.getObDate(),
//                            null, null));
//
//                    // 재고 예정 수량 업데이트
//                    stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + stockDto.getQuantity());
//                    obService.updateStock(stockDto);
//
//                } else if (count <= stockDto.getQuantity()) {
//                    obDetailDtos.add(new ObDetailDto(stockDto.getManufactureDate(), selectedOb.getId(),
//                            selectedOb.getProductId(), count, 'W', selectedOb.getObDate(),
//                            null, null));
//                    // 재고 예정 수량 업데이트
//                    stockDto.setExpectedQuantity(stockDto.getExpectedQuantity() + count);
//                    obService.updateStock(stockDto);
//                    break;
//                }
//            }
//
//            // ob_detail에 삽입
//            obService.insertObDetails(obDetailDtos);
//        }
//    }

//    public void insertObWorker1() {
//        List<ObDetailDto> obDetailDtos = obService.findObDetailByWaitingState();
//        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();
//
//        obView.printObDetail(obDetailDtos);
//        workerView.printAssignableWorker(workerService.findWorkerByAssignableStatus());
//
//        ObDetailDto selectedObDetailDto = null;
//        WorkerDto selectedWorkerDto = null;
//        try {
//            selectedObDetailDto = obDetailDtos.get(obView.getObIndex());
//            selectedWorkerDto = workerDtos.get(workerView.getWorkerIndex());
//        } catch (IndexOutOfBoundsException e) {
//            errorView.printError("없는 번호 입니다.");
//            return;
//        }
//
//        // 지시테이블에 삽입
//        workerService.insertIbWorker(new InstructionDto(selectedObDetailDto.getObId(), selectedObDetailDto.getManufactureDate(),
//                selectedObDetailDto.getProductId(), selectedWorkerDto.getId()));
//
//        // 출고테이블 상태 업데이트
//        selectedObDetailDto.setStatus('P');
//        obService.updateIbState(selectedObDetailDto);
//
//        // 작업자 상태 업데이트
//        selectedWorkerDto.setState('F');
//        workerService.updateWorkerStatus(selectedWorkerDto);
//    }
}
