package com.oopssinsa.model.dto;

import java.time.LocalDate;
//고치기
// 작업자는 본인의 ID로 입고지시 테이블을 조회한다
// locationId를 통해 브랜드와 카테고리를 알 수 있다
public class ObInstructionDto {
    private long obId;

    private LocalDate manufactureDate;
    private String productId;
    private String workerId;
    private long locationId;

    public ObInstructionDto(long ObId, LocalDate manufactureDate, String productId, String workerId, long locationId) {
        this.obId = ObId;
        this.manufactureDate = manufactureDate;
        this.productId = productId;
        this.workerId = workerId;
        this.locationId = locationId;
    }

    public long getId() {
        return obId;
    }

    public void setObId(long obId) {
        this.obId = obId;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }
}
