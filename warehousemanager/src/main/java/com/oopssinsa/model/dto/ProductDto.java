package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class ProductDto {
    private String id;
    private String brandId;
    private String categoryId;
    private String name;
    private String size;
    private String color;
    private int volume;
}
