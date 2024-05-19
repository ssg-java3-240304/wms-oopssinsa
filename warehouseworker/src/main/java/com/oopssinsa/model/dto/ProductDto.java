package com.oopssinsa.model.dto;

// 작업자는 productId를 통해 부피를 얻는다.
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
