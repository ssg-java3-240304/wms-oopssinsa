package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class IbDatailDto {
    private int id;
    private int manufactureId;
    private int productId;
    private String loginId;
    private int quantity;
    private LocalDate ibRequestDate;
    private LocalDate ibDate;
    private String status;

    public IbDatailDto() {
    }

    public IbDatailDto(int id, int manufactureId, int productId, String loginId, int quantity) {
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

    public LocalDate getIbRequestDate() {
        return ibRequestDate;
    }

    public void setIbRequestDate(LocalDate ibRequestDate) {
        this.ibRequestDate = ibRequestDate;
    }

    public LocalDate getIbDate() {
        return ibDate;
    }

    public void setIbDate(LocalDate ibDate) {
        this.ibDate = ibDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IbDatailDto{" +
                "id=" + id +
                ", manufactureId=" + manufactureId +
                ", productId=" + productId +
                ", loginId='" + loginId + '\'' +
                ", quantity=" + quantity +
                ", ibRequestDate=" + ibRequestDate +
                ", ibDate=" + ibDate +
                ", status='" + status + '\'' +
                '}';
    }
}
