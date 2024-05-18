package com.oopssinsa.model.dto;

// 작업자는 본인의 ID로 입고지시 테이블을 조회한다
// locationId를 통해 브랜드와 카테고리를 알 수 있다
public class IbInstructionDto {
    private long ibId;
    private long manufactureID;
    private long productId;
    private String workerId;
    private int locationId;
}
