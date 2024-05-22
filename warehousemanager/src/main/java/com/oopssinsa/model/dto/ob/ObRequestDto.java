package com.oopssinsa.model.dto.ob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

// 전체 컬럼 출력!
@Getter
@Setter
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
