package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.LocationDto;
import java.util.List;

public class IbView {
    public void printAllIb(List<IbDto> ibDtos) {
        System.out.println(
                "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
                        + "입고완료날짜" + "  " + "입고처리상태");
        for (IbDto ibDto : ibDtos) {
            System.out.println(ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId() + "  "
                    + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                    + "  " + ibDto.getIbDate() + "  " + ibDto.getStatus());
        }

        System.out.println();
    }

    public void printIbState(List<IbDto> ibDtos) {
        int count = 1;
        System.out.println(
                "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  " + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  "
                        + "입고처리상태");
        for (IbDto ibDto : ibDtos) {
            System.out.println(
                    (count++) + ". " + ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId()
                            + "  "
                            + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                            + "  " + ibDto.getStatus());
        }

        System.out.println();
    }



    // 수정 진행중 = 입고id + 로케이션 위치 출력 예정
    public void printIbAndCapacity(List<IbDto> ibDtos, List<LocationDto> locationDtos) {
        int count = 1;
        System.out.println((count++) + ". " + "입고ID" + "  " + "제조일자" + "  " + "상품ID" + "  "
                + "발주자ID" + "  " + "수량" + "  " + "입고요청일자" + "  " + "입고처리상태" + "  " + "입고 가능여부"
                + "  " + "현재 용량" + "  " + "예정 용량" + "  " + "최대 용량");
        for (IbDto ibDto : ibDtos) {
            System.out.print(ibDto.getId() + "  " + ibDto.getManufactureDate() + "  " + ibDto.getProductId() + "  "
                    + ibDto.getBrandId() + "  " + ibDto.getQuantity() + "  " + ibDto.getIbRequestDate()
                    + "  " + ibDto.getStatus()+"  ");
            System.out.println(
                    (locationDtos.get(count - 2).getMaxCapacity() - locationDtos.get(count - 2).getCurrentCapacity()
                            - locationDtos.get(count - 2).getExpectedCapacity() - ibDto.getQuantity() >= 0) + "  "
                            + locationDtos.get(count - 2).getCurrentCapacity() + "  " + locationDtos.get(count - 2)
                            .getExpectedCapacity() + "  " + locationDtos.get(count - 2).getMaxCapacity());
        }

        System.out.println();
    }
}
