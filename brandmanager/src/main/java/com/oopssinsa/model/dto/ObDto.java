package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class ObDto {
    private LocalDate menufactureDate;
    private long obId;
    private String productId;
    private int quantity;
    private String status;
    private LocalDate completionDate;
    private int trackingNumber;

    private ObDetailDto obDetailDto;

    public ObDto() {
    }

    public ObDto(LocalDate menufactureDate, long obId, String productId, int quantity, String status, LocalDate completionDate, int trackingNumber) {
        this.menufactureDate = menufactureDate;
        this.obId = obId;
        this.productId = productId;
        this.quantity = quantity;
        this.status = status;
        this.completionDate = completionDate;
        this.trackingNumber = trackingNumber;
    }

    public LocalDate getMenufactureDate() {
        return menufactureDate;
    }

    public void setMenufactureDate(LocalDate menufactureDate) {
        this.menufactureDate = menufactureDate;
    }

    public long getObId() {
        return obId;
    }

    public void setObId(long obId) {
        this.obId = obId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String toString() {
        return "ObDto{" +
                "menufactureDate=" + menufactureDate +
                ", obId=" + obId +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", status='" + status + '\'' +
                ", completionDate=" + completionDate +
                ", trackingNumber=" + trackingNumber +
                '}';
    }
}
