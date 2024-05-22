package com.oopssinsa.controller;

import com.oopssinsa.model.constants.Error;
import com.oopssinsa.model.dto.ib.IbDto;
import com.oopssinsa.model.dto.ib.IbRequestAndLocationDto;
import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.LocationDto;
import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.dto.SectionDto;
import com.oopssinsa.model.dto.WorkerDto;
import com.oopssinsa.model.service.IbService;
import com.oopssinsa.model.service.WorkerService;
import com.oopssinsa.view.ErrorView;
import com.oopssinsa.view.IbView;
import com.oopssinsa.view.InputView;
import com.oopssinsa.view.WorkerView;
import java.util.ArrayList;
import java.util.List;

public class IbController {
    private final IbService ibService;
    private final IbView ibView;
    private final WorkerService workerService;
    private final WorkerView workerView;
    private final InputView inputView;
    private final ErrorView errorView;

    public IbController() {
        this.ibService = new IbService();
        this.ibView = new IbView();
        this.workerService = new WorkerService();
        this.workerView = new WorkerView();
        this.inputView = new InputView();
        this.errorView = new ErrorView();
    }

    public void findAllIb() {
        ibView.printAllIb(ibService.findAllIb());
    }

    public void findIbByRequestState() {
        ibView.printIbState(ibService.findIbByRequestState());
    }

    public void updateState() {
        List<IbDto> requestIbs = ibService.findIbByRequestState();
        List<IbRequestAndLocationDto> ibRequestAndLocation = new ArrayList<>();
        try {
            ibRequestAndLocation = ibService.findIbRequestAndLocation(requestIbs);
        } catch (Exception e) {
            return;
        } finally {
            ibView.printIbAndCapacity(ibRequestAndLocation);
        }

        int ibIndex = ibView.getChangeIbIndex();
        IbDto ibDto = selectRequestIb(ibIndex, requestIbs, ibRequestAndLocation);
        if (ibDto == null) {
            return;
        }

        String select = inputView.getYesOrNo();
        if (select.equalsIgnoreCase("y")) {
            handleApprovedRequest(ibDto, ibRequestAndLocation.get(ibIndex).getIbAvailability());
        } else if (select.equalsIgnoreCase("n")) {
            handleFailedRequest(ibDto);
        }
    }

    public void insertIbWorker() {
        List<IbDto> ibDtos = ibService.findIbByWaitingState();
        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();
        ibView.printIbWaitingState(ibDtos);
        workerView.printAssignableWorker(workerDtos);
        try {
            IbDto selectedIbDto = ibDtos.get(ibView.getProcessIbIndex());
            WorkerDto selectedWorkerDto = workerDtos.get(workerView.getWorkerIndex());

            insertInstruction(selectedIbDto, selectedWorkerDto);
            updateIbToProgressState(selectedIbDto);
            updateWorkerToFalseStatus(selectedWorkerDto);
        } catch (IndexOutOfBoundsException e) {
            errorView.printError(Error.NON_EXISTENT_NUMBER_ERROR);
        }
    }

    private IbDto selectRequestIb(int ibIndex, List<IbDto> requestIbs, List<IbRequestAndLocationDto> ibRequestAndLocation) {
        try {
            for (IbDto requestIb : requestIbs) {
                if (isMatchingRequest(ibIndex, requestIb, ibRequestAndLocation)) {
                    return requestIb;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            errorView.printError(Error.NON_EXISTENT_NUMBER_ERROR);
            return null;
        }

        return null;
    }

    private boolean isMatchingRequest(int ibIndex, IbDto requestIb, List<IbRequestAndLocationDto> ibRequestAndLocation) {
        IbRequestAndLocationDto ibRequestAndLocationDto = ibRequestAndLocation.get(ibIndex);
        return ibRequestAndLocationDto.getIbId().equals(requestIb.getId())
                && ibRequestAndLocationDto.getManufactureDate().equals(requestIb.getManufactureDate())
                && ibRequestAndLocationDto.getProductId().equals(requestIb.getProductId());
    }

    private void handleApprovedRequest(IbDto ibDto, char ibAvailability) {
        SectionDto sectionDto = ibService.findSectionByBrandId(ibDto.getBrandId());
        ProductDto productDto = ibService.findProductByProductId(ibDto.getProductId());
        LocationDto locationDto = ibService.findLocationByCategoryIdAndSectionId(
                productDto.getCategoryId(), sectionDto.getId());

        if (ibAvailability == 'T') {
            updateToWaitingState(ibDto, locationDto, sectionDto);
        } else {
            ibView.printOverCapacity();
        }
    }

    private void handleFailedRequest(IbDto ibDto) {
        ibDto.setStatus('F');
        ibService.updateIbState(ibDto);
    }

    private void updateToWaitingState(IbDto ibDto, LocationDto locationDto, SectionDto sectionDto) {
        ibDto.setStatus('W');
        ProductDto productDto = ibService.findProductByProductId(ibDto.getProductId());

        locationDto.setExpectedCapacity(locationDto.getExpectedCapacity() + ibDto.getQuantity()* productDto.getVolume());
        sectionDto.setExpectedCapacity(sectionDto.getExpectedCapacity() + ibDto.getQuantity()* productDto.getVolume());

        ibService.updateIbState(ibDto);
        ibService.updateExpectedCapacityLocation(locationDto);
        ibService.updateExpectedCapacitySection(sectionDto);
    }

    private void insertInstruction(IbDto selectedIbDto, WorkerDto selectedWorkerDto) {
        workerService.insertIbWorker(new InstructionDto(
                selectedIbDto.getId(),
                selectedIbDto.getManufactureDate(),
                selectedIbDto.getProductId(),
                selectedWorkerDto.getId()
        ));
    }

    private void updateIbToProgressState(IbDto selectedIbDto) {
        selectedIbDto.setStatus('P');
        ibService.updateIbState(selectedIbDto);
    }

    private void updateWorkerToFalseStatus(WorkerDto selectedWorkerDto) {
        selectedWorkerDto.setStatus('F');
        workerService.updateWorkerStatus(selectedWorkerDto);
    }
}
