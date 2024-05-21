package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
//고치기
// 작업자는 본인의 ID로 입고지시 테이블을 조회한다
// locationId를 통해 브랜드와 카테고리를 알 수 있다
@Setter
@Getter
@NoArgsConstructor
public class ObInstructionDto {
    private long id;
    private LocalDate manufactureId;
    private String productId;
    private String workerId;
//    private long locationId;

    public ObInstructionDto(long id, LocalDate manufactureId, String productId, String workerId) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.workerId = workerId;
//        this.locationId = locationId;
    }
}
