package com.oopssinsa.view;

import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import java.util.List;

public class ObView {
    private final InputView inputView;

    public ObView() {
        this.inputView = new InputView();
    }


    public void printObRequestState(List<ObRequestDto> obRequestDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(89) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |  발주자ID  |  수량  |  수령인  |      배송지      | 출고요청일자 |");
        System.out.println("|" + "-".repeat(89) + "|");

        for (ObRequestDto obRequestDto : obRequestDtos) {
            System.out.printf("|%5d| %8s| %11s| %10s| %6d| %6s| %14s| %11s|\n",
                    (count++), obRequestDto.getId(), obRequestDto.getProductId(),
                    obRequestDto.getLoginId(), obRequestDto.getQuantity(),
                    obRequestDto.getRecipientName(), obRequestDto.getAddress(), obRequestDto.getObDate());
        }

        System.out.println("+" + "-".repeat(89) + "+\n");
    }

    public void printAllOb(List<ObDto> obDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(137) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |   제조일자   |  수량  | 발주자ID |  수령인  |      배송지      |"
                + " 출고요청일자 | 출고완료일자 | 출고처리상태 | 운송장번호 |");
        System.out.println("|" + "-".repeat(137) + "|");
        for (ObDto obDto : obDtos) {
            System.out.printf("|%5d|  %7s| %11s| %11s| %,6d| %8s| %6s| %14s|  %10s| %11s| %11c| %9s|\n",
                    (count++), obDto.getObId(), obDto.getProductId(),
                    obDto.getManufactureDate(), obDto.getQuantity(), obDto.getLoginId(),
                    obDto.getRecipientName(), obDto.getAddress(),
                    obDto.getObDate(), obDto.getCompletionObDate(), obDto.getStatus(), obDto.getTrackingNumber());
        }

        System.out.println("+" + "-".repeat(137) + "+\n");
    }

    public int getChangeObIndex() {
        System.out.println("상태를 변경할 출고요청을 선택해주세요.");
        return inputView.getNumber() - 1;
    }
    public void printObRequestAndStock(List<ObRequestAndStockDto> obRequestAndStockDtos) {
        int count = 1;
        System.out.println("출고 요청 & 재고 목록");
        System.out.println("+" + "-".repeat(138) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |  발주자ID  |  출고요청수량  |  수령인  |      배송지      |"
                + " 출고요청일자 | 출고가능여부 |  하위위치  | 재고수량 | 예정수량 |");
        System.out.println("|" + "-".repeat(138) + "|");

        for (ObRequestAndStockDto obRequestAndStockDto : obRequestAndStockDtos) {
            System.out.printf("|%5d|  %7s| %11s| %10s| %,12d| %6s| %14s| %11s| %11c| %10s| %,7d| %,7d|\n",
                    (count++), obRequestAndStockDto.getId(), obRequestAndStockDto.getProductId(),
                    obRequestAndStockDto.getLoginId(), obRequestAndStockDto.getQuantity(),
                    obRequestAndStockDto.getRecipientName(), obRequestAndStockDto.getAddress(),
                    obRequestAndStockDto.getObDate(),obRequestAndStockDto.getObStatus(),
                    obRequestAndStockDto.getSubLocationId(), obRequestAndStockDto.getStockQuantity(),
                    obRequestAndStockDto.getExpectedStockQuantity());
        }

        System.out.println("|" + "-".repeat(138) + "|");
    }

    public void printObDetail(List<ObDetailDto> obDetailDtos) {
        int count = 1;
        System.out.println("출고 대기 상태 목록");
        System.out.println("+" + "-".repeat(99) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |   제조일자   |  수량  | 출고처리상태 | 출고요청일자 |" +
                " 출고완료일자 | 운송장번호 |");
        System.out.println("|" + "-".repeat(99) + "|");

        for (ObDetailDto obDetailDto : obDetailDtos) {
            System.out.printf("|%5d|  %7s| %11s| %11s| %,6d| %11c| %11s| %11s| %9d|\n",
                    (count++), obDetailDto.getObId(), obDetailDto.getProductId(),
                    obDetailDto.getManufactureDate(), obDetailDto.getQuantity(), obDetailDto.getStatus(),
                    obDetailDto.getObDate(), obDetailDto.getCompletionDate(), obDetailDto.getTrackingNumber());
        }

        System.out.println("+" + "-".repeat(99) + "+\n");
    }

    public void printImpossibleOb() {
        System.out.println("해당 요청은 출고할 수 없습니다.");
    }

    public int getObIndex() {
        System.out.println("진행할 출고를 선택해 주세요.");
        return inputView.getNumber() - 1;
    }
}
