package com.oopssinsa.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StockListDto {
    private LocalDate manufactureDate;
    private String productId;
    private int quantity;
    private LocalDate date;
    private String id;
    private long brandId;
    private long categoryId;
    private String name;
    private String size;
    private String color;
    private int volume;
}
