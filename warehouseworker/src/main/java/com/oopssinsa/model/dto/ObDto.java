package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

// 출고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 출고완료일자와 출고처리상태, 운송장을 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
@Setter
@Getter
@NoArgsConstructor
//@ToString
public class ObDto {
    private long id;
    private LocalDate manufactureId;
    private String productId;
    private int quantity;
    private LocalDate obDate;
    private String status;
    private int trackingNumber;

    public ObDto(long id, LocalDate manufactureId, String productId, int quantity, LocalDate obDate, String status, int trackingNumber) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.obDate = obDate;
        this.status = status;
        this.trackingNumber = trackingNumber;
    }

}