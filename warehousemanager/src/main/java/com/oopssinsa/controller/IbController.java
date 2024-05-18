package com.oopssinsa.controller;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.LocationDto;
import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.dto.SectionDto;
import com.oopssinsa.model.service.IbService;
import com.oopssinsa.view.IbView;
import com.oopssinsa.view.InputView;
import java.util.List;

public class IbController {

    private final IbService ibService;
    private final IbView ibView;
    private final InputView inputView;

    public IbController() {
        this.ibService = new IbService();
        this.ibView = new IbView();
        this.inputView = new InputView();
    }

    public void findAllIb() {
        ibView.printAllIb(ibService.findAllIb());
    }

    public void findIbByRequestState() {
        ibView.printRequestIb(ibService.findIbByRequestState());
    }

    public void updateState() {
        List<IbDto> requestIbs = ibService.findIbByRequestState();
        System.out.println("입고 id를 입력해 주세요.");
        ibView.printRequestIb(requestIbs);
        String id = inputView.getId();
        IbDto ibDto = null;

        for (IbDto requestIb : requestIbs) {
            if (requestIb.getId().equals(id)) {
                ibDto = requestIb;
            }
        }

        if (ibDto == null) {
            System.out.println("존재하지 않는 입고 요청 id입니다.");
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
            if (locationDto.getCurrentCapacity() + locationDto.getExpectedCapacity() + ibDto.getQuantity()
                    <= locationDto.getMaxCapacity()) {
                ibDto.setStatus('W');
                locationDto.setExpectedCapacity(locationDto.getExpectedCapacity()+ibDto.getQuantity());
                sectionDto.setExpectedCapacity(sectionDto.getExpectedCapacity()+ibDto.getQuantity());
                ibService.updateState(ibDto);
                ibService.updateExpectedCapacity(locationDto);
                ibService.updateExpectedCapacity(sectionDto);
            } else {
                System.out.println("용량을 초과하였습니다.");
            }

            // 제거필요
            System.out.println(locationDto.getExpectedCapacity());
            System.out.println(sectionDto.getExpectedCapacity());
        }

        // 실패상태로 업데이트
        if (select.equalsIgnoreCase("n")) {
            ibDto.setStatus('F');
            ibService.updateState(ibDto);
        }

        // 제거 필요 - 테스트
        ibView.printAllIb(List.of(ibDto));
    }
}
