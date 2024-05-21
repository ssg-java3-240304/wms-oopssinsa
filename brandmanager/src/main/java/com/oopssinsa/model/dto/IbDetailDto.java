package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class IbDetailDto {
    private long id;
    private LocalDate manufactureId;
    private String productId;
    private String loginId;
    private int quantity;
    private LocalDate ibDate;
    private LocalDate completionDate;
    private String status;

    public IbDetailDto() {
    }

//    public IbDetailDto(long id, LocalDate manufactureId, String productId, String loginId, int quantity) {
//        this.id = id;
//        this.manufactureId = manufactureId;
//        this.productId = productId;
//        this.loginId = loginId;
//        this.quantity = quantity;
//    }


    public IbDetailDto(long id, LocalDate manufactureId, String productId, String loginId, int quantity, LocalDate ibDate, LocalDate completionDate, String status) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.loginId = loginId;
        this.quantity = quantity;
        this.ibDate = ibDate;
        this.completionDate = completionDate;
        this.status = status;
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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getIbDate() {
        return ibDate;
    }

    public void setIbDate(LocalDate ibDate) {
        this.ibDate = ibDate;
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

    @Override
    public String toString() {
        return "IbDetailDto{" +
                "id=" + id +
                ", manufactureId=" + manufactureId +
                ", productId=" + productId +
                ", loginId='" + loginId + '\'' +
                ", quantity=" + quantity +
                ", ibDate=" + ibDate +
                ", completionDate=" + completionDate +
                ", status='" + status + '\'' +
                '}';
    }
}