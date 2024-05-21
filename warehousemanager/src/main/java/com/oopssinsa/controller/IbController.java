package com.oopssinsa.controller;

import com.oopssinsa.model.constants.Error;
import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbRequestAndLocationDto;
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
        List<IbRequestAndLocationDto> ibRequestAndLocation = ibService.findIbRequestAndLocation(requestIbs);
        ibView.printIbAndCapacity(ibRequestAndLocation);

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
        locationDto.setExpectedCapacity(locationDto.getExpectedCapacity() + ibDto.getQuantity());
        sectionDto.setExpectedCapacity(sectionDto.getExpectedCapacity() + ibDto.getQuantity());
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
        selectedWorkerDto.setState('F');
        workerService.updateWorkerStatus(selectedWorkerDto);
    }


//    public void updateState() {
//        List<IbDto> requestIbs = ibService.findIbByRequestState();
//        List<IbRequestAndLocationDto> ibRequestAndLocation = ibService.findIbRequestAndLocation(requestIbs);
//        ibView.printIbAndCapacity(ibRequestAndLocation);
//
//        int ibIndex = ibView.getChangeIbIndex();
//        IbDto ibDto = null;
//        char ibAvailability = ' ';
//        try {
//            ibAvailability = ibRequestAndLocation.get(ibIndex).getIbAvailability();
//
//            for (IbDto requestIb : requestIbs) {
//                if (ibRequestAndLocation.get(ibIndex).getIbId().equals(requestIb.getId())
//                        && ibRequestAndLocation.get(ibIndex).getManufactureDate().equals(requestIb.getManufactureDate())
//                        && ibRequestAndLocation.get(ibIndex).getProductId().equals(requestIb.getProductId())) {
//                    ibDto = requestIb;
//                }
//            }
//        } catch (IndexOutOfBoundsException e) {
//            errorView.printError("존재하지 않는 입고 요청 id입니다.");
//            return;
//        }
//
//        String select = inputView.getYesOrNo();
//
//        // 대기상태로 업데이트
//        if (select.equalsIgnoreCase("y")) {
//            SectionDto sectionDto = ibService.findSectionByBrandId(ibDto.getBrandId());
//            ProductDto productDto = ibService.findProductByProductId(ibDto.getProductId());
//            LocationDto locationDto = ibService.findLocationByCategoryIdAndSectionId(
//                    productDto.getCategoryId(),
//                    sectionDto.getId());
//
//            if (ibAvailability == 'T') {
//                ibDto.setStatus('W');
//                locationDto.setExpectedCapacity(locationDto.getExpectedCapacity() + ibDto.getQuantity());
//                sectionDto.setExpectedCapacity(sectionDto.getExpectedCapacity() + ibDto.getQuantity());
//                //입고 상태 업데이트
//                ibService.updateIbState(ibDto);
//                // 위치 예정용량 업데이트
//                ibService.updateExpectedCapacityLocation(locationDto);
//                // 구역 예정용량 업데이트
//                ibService.updateExpectedCapacitySection(sectionDto);
//            } else {
//                ibView.printOverCapacity();
//                return;
//            }
//        }
//
//        // 실패상태로 업데이트
//        if (select.equalsIgnoreCase("n")) {
//            ibDto.setStatus('F');
//            ibService.updateIbState(ibDto);
//        }
//    }
//public void insertIbWorker() {
//        List<IbDto> ibDtos = ibService.findIbByWaitingState();
//        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();
//
//        ibView.printIbWaitingState(ibDtos);
//        workerView.printAssignableWorker(workerDtos);
//        IbDto selectedIbDto = null;
//        WorkerDto selectedWorkerDto = null;
//        try {
//            selectedIbDto = ibDtos.get(ibView.getProcessIbIndex());
//            selectedWorkerDto = workerDtos.get(workerView.getWorkerIndex());
//        } catch (IndexOutOfBoundsException e) {
//            errorView.printError("없는 번호 입니다.");
//        }
//
//        // 지시테이블에 삽입
//        workerService.insertIbWorker(new InstructionDto(selectedIbDto.getId(), selectedIbDto.getManufactureDate(),
//                selectedIbDto.getProductId(), selectedWorkerDto.getId()));
//
//        // 입고테이블 상태 업데이트
//        selectedIbDto.setStatus('P');
//        ibService.updateIbState(selectedIbDto);
//
//        // 작업자 상태 업데이트
//        selectedWorkerDto.setState('F');
//        workerService.updateWorkerStatus(selectedWorkerDto);
//
//    }

}
