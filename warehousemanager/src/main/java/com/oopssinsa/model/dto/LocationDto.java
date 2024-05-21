package com.oopssinsa.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class LocationDto {
    private String id;
    private char sectionId;
    private String categoryId;
    private int currentCapacity;
    private int expectedCapacity;
    private int maxCapacity;

//    public LocationDto(char sectionId, String categoryId, int currentCapacity, int expectedCapacity, int maxCapacity) {
//        this.sectionId = sectionId;
//        this.categoryId = categoryId;
//        this.currentCapacity = currentCapacity;
//        this.expectedCapacity = expectedCapacity;
//        this.maxCapacity = maxCapacity;
//    }
}


