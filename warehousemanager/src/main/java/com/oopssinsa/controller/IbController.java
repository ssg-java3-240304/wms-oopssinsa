package com.oopssinsa.controller;

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
//        ibView.printIbAndCapacity(requestIbs, ibService.findLocationsByIbDtos(requestIbs));

        List<IbRequestAndLocationDto> ibRequestAndLocation = ibService.findIbRequestAndLocation(requestIbs);
        ibView.printIbAndCapacity(ibRequestAndLocation);
//        ibView.printIbState(requestIbs);

        int ibIndex = ibView.getChangeIbIndex();
        IbDto ibDto = null;
        char ibAvailability = ' ';
        try {
            ibAvailability = ibRequestAndLocation.get(ibIndex).getIbAvailability();

            for (IbDto requestIb : requestIbs) {
                if (ibRequestAndLocation.get(ibIndex).getId().equals(requestIb.getId())
                        && ibRequestAndLocation.get(ibIndex).getManufactureDate().equals(requestIb.getManufactureDate())
                        && ibRequestAndLocation.get(ibIndex).getProductId().equals(requestIb.getProductId())) {
                    ibDto = requestIb;
                }
            }
//            ibDto = requestIbs.get(ibIndex); // index error 처리
        } catch (IndexOutOfBoundsException e) {
            errorView.printError("존재하지 않는 입고 요청 id입니다.");
            return;
        }

        String select = inputView.getYesOrNo();

        // 대기상태로 업데이트
        if (select.equalsIgnoreCase("y")) {
            SectionDto sectionDto = ibService.findSectionByBrandId(ibDto.getBrandId());
            ProductDto productDto = ibService.findProductByProductId(ibDto.getProductId());
            LocationDto locationDto = ibService.findLocationByCategoryIdAndSectionId(
                    productDto.getCategoryId(),
                    sectionDto.getId());

            // 제거필요
            System.out.println(locationDto.getExpectedCapacity());
            System.out.println(sectionDto.getExpectedCapacity());

            // 각 테이블 업데이트 (입고테이블 - 상태, 서브위치테이블 - 예정용량, 구역테이블 - 예정용량)
//            if (locationDto.getCurrentCapacity() + locationDto.getExpectedCapacity() + ibDto.getQuantity()
//                    <= locationDto.getMaxCapacity()) {
            if (ibAvailability == 'T') {
                ibDto.setStatus('W');
                locationDto.setExpectedCapacity(locationDto.getExpectedCapacity() + ibDto.getQuantity());
                sectionDto.setExpectedCapacity(sectionDto.getExpectedCapacity() + ibDto.getQuantity());
                ibService.updateIbState(ibDto);
                ibService.updateExpectedCapacity(locationDto);
                ibService.updateExpectedCapacity(sectionDto);
            } else {
                ibView.printOverCapacity();
                return;
            }

            // 제거필요
            System.out.println(locationDto.getExpectedCapacity());
            System.out.println(sectionDto.getExpectedCapacity());
        }

        // 실패상태로 업데이트
        if (select.equalsIgnoreCase("n")) {
            ibDto.setStatus('F');
            ibService.updateIbState(ibDto);
        }

        // 제거 필요 - 테스트
        ibView.printAllIb(List.of(ibDto));
    }

    public void insertIbWorker() {
        List<IbDto> ibDtos = ibService.findIbByWaitingState();
        List<WorkerDto> workerDtos = workerService.findWorkerByAssignableStatus();

        ibView.printIbWaitingState(ibDtos);

        workerView.printAssignableWorker(workerDtos);
        IbDto selectedIbDto = null;
        WorkerDto selectedWorkerDto = null;
        try {
            selectedIbDto = ibDtos.get(ibView.getProcessIbIndex());
            selectedWorkerDto = workerDtos.get(workerView.getWorkerIndex());
        } catch (IndexOutOfBoundsException e) {
            errorView.printError("없는 번호 입니다.");
        }

        // 지시테이블에 삽입
        workerService.insertIbWorker(new InstructionDto(selectedIbDto.getId(), selectedIbDto.getManufactureDate(),
                selectedIbDto.getProductId(), selectedWorkerDto.getId()));

        // 입고테이블 상태 업데이트
        selectedIbDto.setStatus('P');
        ibService.updateIbState(selectedIbDto);

        // 작업자 상태 업데이트
        selectedWorkerDto.setState('F');
        workerService.updateWorkerStatus(selectedWorkerDto);

        System.out.println(selectedIbDto.getStatus());
        System.out.println(selectedWorkerDto.getState());
    }
}
