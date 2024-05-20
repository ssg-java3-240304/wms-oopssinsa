package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class IbDetailDto {
    private int id;
    private int manufactureId;
    private int productId;
    private String loginId;
    private int quantity;
    private LocalDate ibDate;
    private LocalDate completionDate;
    private String status;

    public IbDetailDto() {
    }

    public IbDetailDto(int id, int manufactureId, int productId, String loginId, int quantity) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.loginId = loginId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(int manufactureId) {
        this.manufactureId = manufactureId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
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