package com.oopssinsa.model.dto;

public class ProductDto {
    // 상품1
    // 브랜드매니저는 상품등록을 하고 입고요청을 보낸다.
    private String id;
    private long brandId;
    private long categoryId;
    private String name;
    private String size;
    private String color;
    private int volume;

    public ProductDto() {
    }

    public ProductDto(String id, long brandId, long categoryId, String name, String size, String color, int volume) {
        this.id = id;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.name = name;
        this.size = size;
        this.color = color;
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id='" + id + '\'' +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", volume=" + volume +
                '}';
    }
}
