package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// 입고시 작업자는 지시서에서 locationId를 얻어온다.
// 출고시 작업자는 지시서에서 locationId를 얻어온다.
// 작업자는 productId와 manufactureId, locationID를 통해
// 입고처리에서 얻은 수량을 계산해 재고 수량을 변경한다.
@Setter
@Getter
@NoArgsConstructor
public class StockDto {
    private String productId;
    private LocalDate manufactureId;
    private long locationId;
    private int quantity;
    private int expectedQuantity;

    public StockDto(String productId, LocalDate manufactureId, long locationId, int quantity, int expectedQuantity) {
        this.productId = productId;
        this.manufactureId = manufactureId;
        this.locationId = locationId;
        this.quantity = quantity;
        this.expectedQuantity = expectedQuantity;
    }

}
