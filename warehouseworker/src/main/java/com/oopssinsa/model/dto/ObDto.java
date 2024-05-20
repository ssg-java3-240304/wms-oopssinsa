package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 출고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 출고완료일자와 출고처리상태, 운송장을 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class ObDto {
    private long obId;
    private LocalDate manufactureDate;
    private String productId;
    private int quantity;
    private LocalDate completionDate;
    private String status;
    private int trackingNumber;

    public ObDto(long obId, LocalDate manufactureDate, String productId, int quantity, LocalDate completionDate, String status, int trackingNumber) {
        this.obId = obId;
        this.manufactureDate = manufactureDate;
        this.productId = productId;
        this.quantity = quantity;
        this.completionDate = completionDate;
        this.status = status;
        this.trackingNumber = trackingNumber;
    }

    public long getObId() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
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
