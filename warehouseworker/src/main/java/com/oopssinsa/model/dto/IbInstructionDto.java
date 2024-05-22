package com.oopssinsa.model.dto;

// 작업자는 본인의 ID로 입고지시 테이블을 조회한다
// locationId를 통해 브랜드와 카테고리를 알 수 있다

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
//@NoArgsConstructor
public class IbInstructionDto {

    private long ibId;
    private LocalDate manufactureId;
    private String productId;
    private String workerId;
//    private int locationId;

    public IbInstructionDto(long ibId, LocalDate manufactureId, String productId, String workerId) {
        this.ibId = ibId;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.workerId = workerId;
//        this.locationId = locationId;
    }

    public void setIbId(long ibId) {
        this.ibId = ibId;
    }

    public void setManufactureId(LocalDate manufactureID) {
        this.manufactureId = manufactureId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

//    public int getLocationId() {
//        return locationId;
//    }
//
//    public void setLocationId(int locationId) {
//        this.locationId = locationId;
//    }
}
