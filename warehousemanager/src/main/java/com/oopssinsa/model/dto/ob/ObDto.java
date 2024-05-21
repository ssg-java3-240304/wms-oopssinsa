package com.oopssinsa.model.dto.ob;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
// 조인 테이블
@Getter
@Setter
@AllArgsConstructor
public class ObDto {
    private LocalDate manufactureDate;
    private String obId;
    private String productId;
    private String loginId;
    private String recipientName;
    private String address;
    private int quantity;
    private char status;
    private LocalDate obDate;
    private LocalDate completionObDate;
    private String trackingNumber;
}
