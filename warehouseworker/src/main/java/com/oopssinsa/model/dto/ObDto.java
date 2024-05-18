package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 출고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 출고완료일자와 출고처리상태, 운송장을 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class ObDto {
    private long id;
    private LocalDate manufactureId;
    private long productId;
    private int quantity;
    private LocalDate obDate;
    private String status;
    private int trackingNumber;

    public ObDto(long id, LocalDate manufactureId, long productId, int quantity, LocalDate obDate, String status, int trackingNumber) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.obDate = obDate;
        this.status = status;
        this.trackingNumber = trackingNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(LocalDate manufactureId) {
        this.manufactureId = manufactureId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getObDate() {
        return obDate;
    }

    public void setObDate(LocalDate obDate) {
        this.obDate = obDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
