package com.oopssinsa.model.dto;

// 작업자는 본인의 ID로 입고지시 테이블을 조회한다
// locationId를 통해 브랜드와 카테고리를 알 수 있다
public class ObInstructionDto {
    private long id;
    private long manufactureId;
    private long productId;
    private long workerId;
    private String locationId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(long manufactureId) {
        this.manufactureId = manufactureId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }
}
