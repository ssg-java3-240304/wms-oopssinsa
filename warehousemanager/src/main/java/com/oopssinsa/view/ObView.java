package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbDto;

import com.oopssinsa.model.dto.ObDto;
import java.util.List;

public class ObView {

    public void printObRequestState(List<ObDto> obDtos) {
        int count = 1;
        for (ObDto obDto : obDtos) {
            System.out.println(
                    "출고ID" + "  " + "상품ID"  + "  " + "발주자ID" + "  " + "수량" + "  " + "수령인" + "  "
                            + "배송지");
            System.out.println(
                    (count++) + ". " + obDto.getId() + "  " + obDto.getProductId() + "  " + obDto.getLoginId()
                            + "  "
                            + obDto.getQuantity() + "  " + obDto.getRecipientName() + "  " + obDto.getAddress()
                            );
        }

        System.out.println();
    }
}
