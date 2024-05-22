package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 작업자는 productId를 통해 부피를 얻는다.
@Setter
@Getter
//@NoArgsConstructor
public class ProductDto {
    private String id;
    private int brandId;
    private long categoryId;
    private int volume;

    public ProductDto(String id, int brandId, long categoryId, int volume) {
        this.id = id;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.volume = volume;
    }

}
