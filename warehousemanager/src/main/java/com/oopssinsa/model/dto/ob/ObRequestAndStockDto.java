package com.oopssinsa.model.dto.ob;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ObRequestAndStockDto {
    private String id;
    private String productId;
    private String loginId;
    private int quantity;
    private String recipientName;
    private String address;
    private LocalDate obDate; // ob_request
    // productId로 조인하되, ob_request의 quantity가 stock의 quantity보다 적은지 출력
    private char obStatus; // 출고 가능여부
    private String subLocationId;
    private Integer stockQuantity;
    private Integer expectedStockQuantity;



}
