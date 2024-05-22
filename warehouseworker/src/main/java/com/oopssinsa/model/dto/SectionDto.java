package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 이건 그냥 location이 변경됐을 때 location에서 얻어온 sumOfSection으로 업데이트하기
@Setter
@Getter
//@NoArgsConstructor
public class SectionDto {
    private String id; // 알파벳임
    private int brandId;
    private int currentCapacity;
    private int expectedCapacity;

    public SectionDto(String id, int brandId, int currentCapacity, int expectedCapacity) {
        this.id = id;
        this.brandId = brandId;
        this.currentCapacity = currentCapacity;
        this.expectedCapacity = expectedCapacity;
    }

}
