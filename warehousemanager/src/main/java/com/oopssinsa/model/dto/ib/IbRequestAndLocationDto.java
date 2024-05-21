package com.oopssinsa.model.dto.ib;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IbRequestAndLocationDto {
    private String ibId;
    private LocalDate manufactureDate;
    private String productId;
    private String brandId;
    private int quantity;
    private int volume; // 추가
    private int capacity;  // 추가
    private LocalDate ibRequestDate;
    private char ibStatus;
    private char ibAvailability;
    private int currentCapacity;
    private int expectedCapacity;
    private int maxCapacity;
}
