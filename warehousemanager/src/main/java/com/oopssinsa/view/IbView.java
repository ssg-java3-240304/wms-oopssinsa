package com.oopssinsa.view;

import com.oopssinsa.model.dto.ib.IbDto;
import com.oopssinsa.model.dto.ib.IbRequestAndLocationDto;

import java.util.List;

public class IbView {

    private final InputView inputView;

    public IbView() {
        this.inputView = new InputView();
    }

    public void printAllIb(List<IbDto> ibDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(106) + "+");
        System.out.printf("| 번호 |  %4s  |   %4s   |    %4s    |  %5s  |  %2s  |  %6s  |  %6s  | %6s |\n", "입고ID", "제조일자", "상품ID", "발주자ID"
                , "수량", "입고요청일자", "입고완료날짜", "입고처리상태");
        System.out.println("|" + "-".repeat(106) + "|");
        for (IbDto ibDto : ibDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %13s| %13s| %11c|\n",
                    (count++), ibDto.getId(), ibDto.getManufactureDate(), ibDto.getProductId(),
                    ibDto.getBrandId(), ibDto.getQuantity(), ibDto.getIbRequestDate(),
                    ibDto.getIbDate(), ibDto.getStatus());

        }

        System.out.println("+" + "-".repeat(106) + "+\n");
    }

    public void printIbState(List<IbDto> ibDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(91) + "+");
        System.out.printf("| 번호 |  %4s  |   %4s   |    %4s    |  %5s  |  %2s  |  %6s  | %6s |\n",
                "입고ID", "제조일자", "상품ID", "발주자ID", "수량", "입고요청일자", "입고처리상태");
        System.out.println("|" + "-".repeat(91) + "|");
        for (IbDto ibDto : ibDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %13s| %11c|\n",
                    (count++), ibDto.getId(), ibDto.getManufactureDate(), ibDto.getProductId(),
                    ibDto.getBrandId(), ibDto.getQuantity(), ibDto.getIbRequestDate(), ibDto.getStatus());
        }

        System.out.println("+" + "-".repeat(91) + "+\n");

    }

    public void printIbWaitingState(List<IbDto> ibDtos) {
        System.out.println("입고대기 상태 목록");
        printIbState(ibDtos);
    }

    public void printIbAndCapacity(List<IbRequestAndLocationDto> ibRequestAndLocationDtos) {
        int count = 1;
        System.out.println("입고 & 적재 위치 용량 목록");
        System.out.println("+" + "-".repeat(148) + "+");
        System.out.println("| 번호 |  입고ID  |   제조일자   |    상품ID    |  발주자ID  |  수량  | 부피 | 입고용량 |  입고요청일자  |" +
                " 입고처리상태 | 입고가능여부 | 현재용량 | 예정용량 | 최대용량 |");
        System.out.println("|" + "-".repeat(148) + "|");

        for (IbRequestAndLocationDto ibRequestAndLocationDto : ibRequestAndLocationDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %,5d| %,7d| %13s| %11c| %11c| %,7d| %,8d| %,7d|\n",
                    (count++), ibRequestAndLocationDto.getIbId(), ibRequestAndLocationDto.getManufactureDate(),
                    ibRequestAndLocationDto.getProductId(), ibRequestAndLocationDto.getBrandId(),
                    ibRequestAndLocationDto.getQuantity(),ibRequestAndLocationDto.getVolume(),
                    ibRequestAndLocationDto.getCapacity(), ibRequestAndLocationDto.getIbRequestDate(),
                    ibRequestAndLocationDto.getIbStatus(), ibRequestAndLocationDto.getIbAvailability(),
                    ibRequestAndLocationDto.getCurrentCapacity(), ibRequestAndLocationDto.getExpectedCapacity(),
                    ibRequestAndLocationDto.getMaxCapacity());
        }

        System.out.println("+" + "-".repeat(148) + "+");
    }

    public int getChangeIbIndex() {
        System.out.println("상태를 변경할 입고를 선택해 주세요.");
        return inputView.getNumber() - 1;
    }

    public int getProcessIbIndex() {
        System.out.println("진행할 입고를 선택해 주세요.");
        return inputView.getNumber() - 1;
    }

    public void printOverCapacity() {
        System.out.println("용량을 초과하였습니다.");
    }
}
