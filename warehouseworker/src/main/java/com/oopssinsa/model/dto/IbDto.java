package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 입고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 입고완료일자와 입고처리상태를 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class IbDto {
    private long id;
    private long manufactureId;
    private long productId;
    private int quantity;
    private LocalDate completionDate;
    private String Status;
}
