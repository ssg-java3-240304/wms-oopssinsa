package com.oopssinsa.view;

import com.oopssinsa.model.dto.ObDetailDto;
import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ObRequestDto;

import java.util.List;

public class ObView {

    public void printObRequestState(List<ObRequestDto> obRequestDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(76) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |  발주자ID  |  수량  |      수령인      |  배송지  |");
        System.out.println("|" + "-".repeat(76) + "|");
//        System.out.println(
//                "출고ID" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "수령인" + "  "
//                        + "배송지");
        for (ObRequestDto obRequestDto : obRequestDtos) {
            System.out.printf("|%5d|  %7s| %11s| %10s| %6d| %16s| %8s|\n",
                    (count++), obRequestDto.getId(), obRequestDto.getProductId(),
                    obRequestDto.getLoginId(), obRequestDto.getQuantity(),
                    obRequestDto.getRecipientName(), obRequestDto.getAddress());

//            System.out.println(
//                    (count++) + ". " + obRequestDto.getId() + "  " + obRequestDto.getProductId() + "  "
//                            + obRequestDto.getLoginId()
//                            + "  "
//                            + obRequestDto.getQuantity() + "  " + obRequestDto.getRecipientName() + "  "
//                            + obRequestDto.getAddress()
//            );
        }

        System.out.println("+" + "-".repeat(76) + "+\n");
    }

    public void printAllOb(List<ObDto> obDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(125) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |   제조일자   |  수량  | 발주자ID |      수령인      |  배송지  |"
                + "   출고일자   | 출고처리상태 | 운송장번호 |");
        System.out.println("|" + "-".repeat(125) + "|");
//        System.out.println(
//                "출고ID" + "  " + "상품ID" + "  " + "제조일자" + "  " + "수량" + "  "
//                        + "발주자ID" + "  " + "수령인" + "  " + "배송지" + "  " + "출고일자" + "  " + "출고처리상태" + "  " + "운송장번호");
        for (ObDto obDto : obDtos) {
            System.out.printf("|%5d|  %7s| %11s| %11s| %,6d| %8s| %15s| %8s| %12s| %11c| %9d|\n",
                    (count++), obDto.getObId(), obDto.getProductId(),
                    obDto.getManufactureDate(), obDto.getQuantity(), obDto.getLoginId(),
                    obDto.getRecipientName(), obDto.getAddress(),
                    obDto.getObDate(), obDto.getStatus(), obDto.getTrackingNumber());

//            System.out.println(
//                    (count++) + ". " + obDto.getObId() + "  " + obDto.getManufactureDate() + "  "
//                            + obDto.getTrackingNumber()
//                            + "  "
//                            + obDto.getQuantity() + "  " + obDto.getLoginId() + "  " + obDto.getRecipientName() + "  "
//                            + obDto.getAddress() + "  " + obDto.getObDate() + "  " + obDto.getStatus() + "  "
//                            + obDto.getTrackingNumber()
//            );
        }

        System.out.println("+" + "-".repeat(125) + "+\n");
    }

    public void printObRequestAndStock(List<ObRequestAndStockDto> obRequestAndStockDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(131) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |  발주자ID  |  출고요청수량  |      수령인      |  배송지  |"
                + " 출고상태여부 |     하위위치     | 재고수량 | 예정수량 |");
        System.out.println("|" + "-".repeat(131) + "|");
//        System.out.println(
//                "출고ID" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "출고요청수량" + "  " + "수령인" + "  "
//                        + "배송지" + "  " + "출고상태여부" + "  " + "하위위치" + "  " + "재고수량" + "  " + "예정수량");
        for (ObRequestAndStockDto obRequestAndStockDto : obRequestAndStockDtos) {
            System.out.printf("|%5d|  %7s| %11s| %10s| %,12d| %16s| %8s| %11c| %10s| %,8d| %,7d|\n",
                    (count++), obRequestAndStockDto.getId(), obRequestAndStockDto.getProductId(),
                    obRequestAndStockDto.getLoginId(), obRequestAndStockDto.getQuantity(),
                    obRequestAndStockDto.getRecipientName(), obRequestAndStockDto.getAddress(),
                    obRequestAndStockDto.getObStatus(), obRequestAndStockDto.getSubLocationId(),
                    obRequestAndStockDto.getStockQuantity(), obRequestAndStockDto.getExpectedStockQuantity());
//            System.out.println(
//                    (count++) + ". " + obRequestAndStockDto.getId() + "  " + obRequestAndStockDto.getProductId() + "  "
//                            + obRequestAndStockDto.getLoginId()
//                            + "  "
//                            + obRequestAndStockDto.getQuantity() + "  " + obRequestAndStockDto.getRecipientName() + "  "
//                            + obRequestAndStockDto.getAddress() + "  " + obRequestAndStockDto.getObStatus() + "  "
//                            + obRequestAndStockDto.getSubLocationId() + "  " + obRequestAndStockDto.getStockQuantity()
//                            + "  " + obRequestAndStockDto.getExpectedStockQuantity()
//            );
        }

        System.out.println("|" + "-".repeat(131) + "|");
    }

    public void printObDetail(List<ObDetailDto> obDetailDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(91) + "+");
        System.out.println("| 번호 |  출고ID  |   상품ID   |   제조일자   |  수량  | 출고처리상태 |     출고일자     |"
                + " 운송장번호 |");
        System.out.println("|" + "-".repeat(91) + "|");

//        System.out.println(
//                "출고ID" + "  " + "상품ID" + "  " + "제조일자" + "  " + "수량" + "  " + "출고처리상태" + "  "
//                        + "출고일자" + "  " + "운송장번호");
        for (ObDetailDto obDetailDto : obDetailDtos) {
            System.out.printf("|%5d|  %7s| %11s| %11s| %,6d| %11c| %16s| %9d|\n",
                    (count++), obDetailDto.getObId(), obDetailDto.getProductId(),
                    obDetailDto.getManufactureDate(), obDetailDto.getQuantity(), obDetailDto.getStatus(),
                    obDetailDto.getObDate(), obDetailDto.getTrackingNumber());
//            System.out.println(
//                    (count++) + ". " + obDetailDto.getObId() + "  " + obDetailDto.getProductId() + "  "
//                            + obDetailDto.getManufactureDate()
//                            + "  "
//                            + obDetailDto.getQuantity() + "  " + obDetailDto.getStatus() + "  "
//                            + obDetailDto.getObDate() + "  " + obDetailDto.getTrackingNumber()
//            );
        }

        System.out.println("+" + "-".repeat(91) + "+\n");
    }
}
