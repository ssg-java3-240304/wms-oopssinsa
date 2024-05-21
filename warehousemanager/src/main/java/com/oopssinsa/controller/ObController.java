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
import com.oopssinsa.view.InputView;
import com.oopssinsa.view.ObView;
import com.oopssinsa.view.WorkerView;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObController {
    private final ObService obService;
    private final ObView obView;
    private final WorkerService workerService;
    private final WorkerView workerView;
    private final ErrorView errorView;
    private final InputView inputView;

    public ObController() {
        this.obService = new ObService();
        this.obView = new ObView();
        this.workerService = new WorkerService();
        this.workerView = new WorkerView();
        this.errorView = new ErrorView();
        this.inputView = new InputView();
    }

    // 출고 요청 조회하기
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

        String select = inputView.getYesOrNo();
        if (select.equalsIgnoreCase("y")) {
            if (selectedOb.getObStatus() == 'F') {
                obView.printImpossibleOb();
                return;
            }
            if (selectedOb.getObStatus() == 'T') {
                processOrderableOb(selectedOb);
            }
        } else if (select.equalsIgnoreCase("n")) {
            insertObDetails(
                    List.of(new ObDetailDto(LocalDate.of(1970, 1, 1), selectedOb.getId(),
                            selectedOb.getProductId(), selectedOb.getQuantity(), 'F', selectedOb.getObDate(),
                            null, null)));
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

    private void processOrderableOb(ObRequestAndStockDto selectedOb) {
        List<StockDto> stockDtos = obService.findStockOrderableByProductId(selectedOb.getProductId());
        List<ObDetailDto> obDetailDtos = new ArrayList<>();
        int requestQuantity = selectedOb.getQuantity();

        for (StockDto stockDto : stockDtos) {
            int possibleStockQuantity = stockDto.getQuantity() - stockDto.getExpectedQuantity();
            if (requestQuantity > possibleStockQuantity) {
                if (possibleStockQuantity == 0) {
                    continue;
                }
                requestQuantity -= possibleStockQuantity;
                obDetailDtos.add(createObDetail(selectedOb, stockDto, possibleStockQuantity));
                updateStockExpectedQuantity(stockDto,possibleStockQuantity);
            } else {
                obDetailDtos.add(createObDetail(selectedOb, stockDto, requestQuantity));
                updateStockExpectedQuantity(stockDto, requestQuantity);
                break;
            }
        }

        insertObDetails(obDetailDtos);
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
        workerService.insertObWorker(new InstructionDto(
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

}
