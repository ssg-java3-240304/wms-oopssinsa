package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 입고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 입고완료일자와 입고처리상태를 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
public class IbDto {
    private long id;
    private LocalDate manufactureId;
    private long productId;
    private int quantity;
    private LocalDate completionDate;
    private String Status;

    public IbDto(long id, LocalDate manufactureId, long productId, int quantity, LocalDate completionDate, String status) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.completionDate = completionDate;
        Status = status;
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

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
