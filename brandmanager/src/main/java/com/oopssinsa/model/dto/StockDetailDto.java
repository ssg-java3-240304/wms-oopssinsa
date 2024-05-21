package com.oopssinsa.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockDetailDto {
    private LocalDate manufactureDate;
    private String productId;
    private int quantity;
    private LocalDate date;

    private ProductDto productDto;

}
