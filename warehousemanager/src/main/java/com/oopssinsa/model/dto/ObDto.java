package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ObDto {
    private String id;
    private String productId;
    private String loginId;
    private int quantity;
    private String recipientName;
    private String address;

}
