package com.oopssinsa.view;

import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObRequestDto;
import java.util.List;

public class ObView {

    public void printObRequestState(List<ObRequestDto> obRequestDtos) {
        int count = 1;
        System.out.println(
                "출고ID" + "  " + "상품ID"  + "  " + "발주자ID" + "  " + "수량" + "  " + "수령인" + "  "
                        + "배송지");
        for (ObRequestDto obRequestDto : obRequestDtos) {
            System.out.println(
                    (count++) + ". " + obRequestDto.getId() + "  " + obRequestDto.getProductId() + "  " + obRequestDto.getLoginId()
                            + "  "
                            + obRequestDto.getQuantity() + "  " + obRequestDto.getRecipientName() + "  " + obRequestDto.getAddress()
                            );
        }

        System.out.println();
    }

    public void printAllOb(List<ObDto> obDtos) {
        int count = 1;
        System.out.println(
                "출고ID"  + "  " + "상품ID" + "  " + "제조일자" + "  " + "수량" + "  "
                        + "발주자ID" + "  "+ "수령인"+ "  "+ "배송지"+ "  "+ "출고일자"+ "  "+ "출고처리상태"+ "  "+ "운송장번호");
        for (ObDto obDto : obDtos) {
            System.out.println(
                    (count++) + ". " + "  " + obDto.getObId() + "  " + obDto.getManufactureDate() + "  "
                            + obDto.getTrackingNumber()
                            + "  "
                            + obDto.getQuantity() + "  " + obDto.getLoginId() + "  " + obDto.getRecipientName() + "  "
                            + obDto.getAddress() + "  " + obDto.getObDate() + "  " + obDto.getStatus() + "  "
                            + obDto.getTrackingNumber()
            );
        }

        System.out.println();
    }
}
