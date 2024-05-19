package com.oopssinsa.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IbRequestAndLocationDto {
    private String id;
    private LocalDate manufactureDate;
    private String productId;
    private String brandId;
    private int quantity;
    private LocalDate ibRequestDate;
    private char ibStatus;
    private char ibAvailability;
    private int currentCapacity;
    private int expectedCapacity;
    private int maxCapacity;
}
