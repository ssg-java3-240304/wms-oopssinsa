package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class ObDetailDto {
    private long id;
    private String productId;
    private String loginId;
    private int quantity;
    private String recipientName;
    private String address;
    private LocalDate obDate;

    private ObDetailDto obDetailDto;


    public ObDetailDto() {
    }

    public ObDetailDto(long id, String productId, String loginId, int quantity, String recipientName, String address, LocalDate obDate) {
        this.id = id;
        this.productId = productId;
        this.loginId = loginId;
        this.quantity = quantity;
        this.recipientName = recipientName;
        this.address = address;
        this.obDate = obDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getObDate() {
        return obDate;
    }

    public void setObDate(LocalDate obDate) {
        this.obDate = obDate;
    }

    @Override
    public String toString() {
        return "ObDetailDto{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", loginId='" + loginId + '\'' +
                ", quantity=" + quantity +
                ", recipientName='" + recipientName + '\'' +
                ", address='" + address + '\'' +
                ", obDate=" + obDate +
                '}';
    }
}
