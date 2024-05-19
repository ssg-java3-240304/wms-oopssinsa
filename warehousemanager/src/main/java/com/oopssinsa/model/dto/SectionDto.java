package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SectionDto {
    private char id;
    private String brandId;
    private int currentCapacity;
    private int expectedCapacity;
    private int maxCapacity;
}
