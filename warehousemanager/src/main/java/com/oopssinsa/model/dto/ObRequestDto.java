package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class ObRequestDto {
    private String id;
    private String productId;
    private String loginId;
    private int quantity;
    private String recipientName;
    private String address;
    private LocalDate obDate;
}
