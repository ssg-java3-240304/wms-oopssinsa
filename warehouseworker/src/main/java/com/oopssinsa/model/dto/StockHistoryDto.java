package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class StockHistoryDto {
    private LocalDate manufactureId;
    private long productId;
    private int quantity; // - or +
    private LocalDate date; // 처리시각

    public StockHistoryDto(LocalDate manufactureId, long productId, int quantity, LocalDate date) {
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
