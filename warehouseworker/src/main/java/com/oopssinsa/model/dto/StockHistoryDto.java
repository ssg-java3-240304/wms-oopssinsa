package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class StockHistoryDto {
    private LocalDate manufactureId;
    private String productId;
    private int quantity; // - or +
    private LocalDate date; // 처리시각

    public StockHistoryDto(LocalDate manufactureId, String productId, int quantity, LocalDate date) {
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
    }

}
