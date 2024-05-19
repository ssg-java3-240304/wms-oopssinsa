package com.oopssinsa.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StockDto {
    private LocalDate manufactureDate;
    private String productId;
    private String subLocationId;
    private int quantity;
    private int expectedQuantity;
}
