package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 입고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 입고완료일자와 입고처리상태를 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class IbDto {
    private long id;
    private LocalDate manufactureId;
    private String productId;
    private int quantity;
    private LocalDate completionDate;
    private char status;

    public IbDto(long id, LocalDate manufactureId, String productId, int quantity, LocalDate completionDate, char status) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
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

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IbDto{" +
                "id=" + id +
                ", manufactureId=" + manufactureId +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", completionDate=" + completionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
