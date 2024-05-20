package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbRequestAndLocationDto;
import com.oopssinsa.model.dto.LocationDto;

import java.util.List;

public class IbView {
    public void printAllIb(List<IbDto> ibDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(106) + "+");
        System.out.printf("| 번호 |  %4s  |   %4s   |    %4s    |  %5s  |  %2s  |  %6s  |  %6s  | %6s |\n", "입고ID", "제조일자", "상품ID", "발주자ID"
                , "수량", "입고요청일자", "입고완료날짜", "입고처리상태");
        System.out.println("|" + "-".repeat(106) + "|");

//        System.out.println(
//                "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
//                        + "입고완료날짜" + "  " + "입고처리상태");
        for (IbDto ibDto : ibDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %13s| %13s| %11c|\n",
                    (count++), ibDto.getId(), ibDto.getManufactureDate(), ibDto.getProductId(),
                    ibDto.getBrandId(), ibDto.getQuantity(), ibDto.getIbRequestDate(),
                    ibDto.getIbDate(), ibDto.getStatus());
//            System.out.println(
//                    (count++) + ". " + ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId()
//                            + "  "
//                            + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
//                            + "  " + ibDto.getIbDate() + "  " + ibDto.getStatus());
        }

        System.out.println("+" + "-".repeat(106) + "+\n");

    }

    public void printIbState(List<IbDto> ibDtos) {
        int count = 1;
//        System.out.println(
//                "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
//                        + "입고처리상태");

        System.out.println("+" + "-".repeat(91) + "+");
        System.out.printf("| 번호 |  %4s  |   %4s   |    %4s    |  %5s  |  %2s  |  %6s  | %6s |\n",
                "입고ID", "제조일자", "상품ID", "발주자ID", "수량", "입고요청일자", "입고처리상태");
        System.out.println("|" + "-".repeat(91) + "|");
        for (IbDto ibDto : ibDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %13s| %11c|\n",
                    (count++), ibDto.getId(), ibDto.getManufactureDate(), ibDto.getProductId(),
                    ibDto.getBrandId(), ibDto.getQuantity(), ibDto.getIbRequestDate(), ibDto.getStatus());
//            System.out.println(
//                    (count++) + ". " + ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId()
//                            + "  "
//                            + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
//                            + "  " + ibDto.getStatus());
        }

        System.out.println("+" + "-".repeat(91) + "+\n");

    }


    // 수정 진행중 = 입고id + 로케이션 위치 출력 예정
    public void printIbAndCapacity(List<IbDto> ibDtos, List<LocationDto> locationDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(91) + "+");
        System.out.println("| 번호 |  입고ID  |   제조일자   |    상품ID    |  발주자ID  |  수량  |  입고요청일자  |" +
                " 입고처리상태 | 입고가능여부 | 현재용량 | 예정용량 | 최대용량 |");
        System.out.println("|" + "-".repeat(91) + "|");

//        System.out.println("입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  "
//                + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  " + "입고처리상태" + "  " + "입고가능여부"
//                + "  " + "현재용량" + "  " + "예정용량" + "  " + "최대용량");
        for (IbDto ibDto : ibDtos) {

            System.out.print(
                    (count++) + ". " + ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId()
                            + "  "
                            + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                            + "  " + ibDto.getStatus() + "  ");
            System.out.println(
                    (locationDtos.get(count - 2).getMaxCapacity() - locationDtos.get(count - 2).getCurrentCapacity()
                            - locationDtos.get(count - 2).getExpectedCapacity() - ibDto.getQuantity() >= 0) + "  "
                            + locationDtos.get(count - 2).getCurrentCapacity() + "  " + locationDtos.get(count - 2)
                            .getExpectedCapacity() + "  " + locationDtos.get(count - 2).getMaxCapacity());
        }

        System.out.println();
    }

    public void printIbAndCapacity(List<IbRequestAndLocationDto> ibRequestAndLocationDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(132) + "+");
        System.out.println("| 번호 |  입고ID  |   제조일자   |    상품ID    |  발주자ID  |  수량  |  입고요청일자  |" +
                " 입고처리상태 | 입고가능여부 | 현재용량 | 예정용량 | 최대용량 |");
        System.out.println("|" + "-".repeat(132) + "|");
//        System.out.println("입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  "
//                + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  " + "입고처리상태" + "  " + "입고 가능여부"
//                + "  " + "현재 용량" + "  " + "예정 용량" + "  " + "최대 용량");
        for (IbRequestAndLocationDto ibRequestAndLocationDto : ibRequestAndLocationDtos) {
            System.out.printf("|%5d|  %7s| %12s| %12s| %10s| %,6d| %13s| %11c| %11c| %,7d| %,8d| %,7d|\n",
                    (count++), ibRequestAndLocationDto.getId(), ibRequestAndLocationDto.getManufactureDate(),
                    ibRequestAndLocationDto.getProductId(), ibRequestAndLocationDto.getBrandId(),
                    ibRequestAndLocationDto.getQuantity(), ibRequestAndLocationDto.getIbRequestDate(),
                    ibRequestAndLocationDto.getIbStatus(),ibRequestAndLocationDto.getIbAvailability(),
                    + ibRequestAndLocationDto.getCurrentCapacity(), ibRequestAndLocationDto.getExpectedCapacity(),
                    ibRequestAndLocationDto.getMaxCapacity());
//            System.out.print(
//                    (count++) + ". " + ibRequestAndLocationDto.getId() + "  "
//                            + ibRequestAndLocationDto.getManufactureDate() + "  "
//                            + ibRequestAndLocationDto.getProductId()
//                            + "  "
//                            + ibRequestAndLocationDto.getBrandId() + "  " + ibRequestAndLocationDto.getQuantity() + "  "
//                            + ibRequestAndLocationDto.getIbRequestDate()
//                            + "  " + ibRequestAndLocationDto.getIbStatus() + "  ");
//            System.out.println(
//                    ibRequestAndLocationDto.getIbAvailability() + "  "
//                            + ibRequestAndLocationDto.getCurrentCapacity() + "  " + ibRequestAndLocationDto
//                            .getExpectedCapacity() + "  " + ibRequestAndLocationDto.getMaxCapacity());
        }

        System.out.println("+" + "-".repeat(132) + "+");
    }
}
