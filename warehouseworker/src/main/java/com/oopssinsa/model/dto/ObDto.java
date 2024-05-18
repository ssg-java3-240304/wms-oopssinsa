package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 출고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 출고완료일자와 출고처리상태, 운송장을 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class ObDto {
    private long id;
    private long manufactureId;
    private long productId;
    private int quantity;
    private LocalDate obDate;
    private String status;
    private int trackingNumber;
}
