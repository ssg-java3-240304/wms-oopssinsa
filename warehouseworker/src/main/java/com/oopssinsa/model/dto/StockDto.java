package com.oopssinsa.model.dto;

import java.time.LocalDate;

// 입고시 작업자는 지시서에서 locationId를 얻어온다.
// 출고시 작업자는 지시서에서 locationId를 얻어온다.
// 작업자는 productId와 manufactureId, locationID를 통해
// 입고처리에서 얻은 수량을 계산해 재고 수량을 변경한다.
public class StockDto {
    private String productId;
    private LocalDate manufactureId;
    private long locationId;
    private int quantity;
    private int expected_quantity;

    public StockDto(String productId, LocalDate manufactureId, long locationId, int quantity, int expected_quantity) {
        this.productId = productId;
        this.manufactureId = manufactureId;
        this.locationId = locationId;
        this.quantity = quantity;
        this.expected_quantity = expected_quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public LocalDate getManufactureId() {
        return manufactureId;
    }

    public void setManufactureId(LocalDate manufactureId) {
        this.manufactureId = manufactureId;
    }

    public long getLocationId() {
        return locationId;
    }

    public void setLocationId(long locationId) {
        this.locationId = locationId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getExpected_quantity() {
        return expected_quantity;
    }

    public void setExpected_quantity(int expected_quantity) {
        this.expected_quantity = expected_quantity;
    }
}
