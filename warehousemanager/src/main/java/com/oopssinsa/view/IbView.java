package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbDto;
import java.util.List;

public class IbView {
    public void printAllIb(List<IbDto> ibDtos) {
        System.out.println();
        for (IbDto ibDto : ibDtos) {
            System.out.println(
                    "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
                            + "입고완료날짜" + "  " + "입고처리상태");
            System.out.println(ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId() + "  "
                    + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                    + "  " + ibDto.getIbDate() + "  " + ibDto.getStatus());
        }

        System.out.println();
    }

    public void printRequestIb(List<IbDto> ibDtos) {
        System.out.println();
        for (IbDto ibDto : ibDtos) {
            System.out.println(
                    "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
                            + "입고처리상태");
            System.out.println(ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId() + "  "
                    + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                    + "  " + ibDto.getStatus());
        }

        System.out.println();
    }


    // 수정 진행중 = 입고id + 로케이션 위치 출력 예정
    public void printIbAndCapacity(List<IbDto> ibDtos) {
        System.out.println();
        for (IbDto ibDto : ibDtos) {
            System.out.println(
                    "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
                            + "입고처리상태");
            System.out.println(ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId() + "  "
                    + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                    + "  " + ibDto.getStatus());
        }

        System.out.println();
    }
}
