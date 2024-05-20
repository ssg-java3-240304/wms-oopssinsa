package com.oopssinsa.model.dto;

public class ProductDto {
    // 상품1
    // 브랜드매니저는 상품등록을 하고 입고요청을 보낸다.
    private String Id;
    private int brandId;
    private int categoryId;
    private String name;
    private String size;
    private String color;
    private int volume;

    public ProductDto() {
    }

    public ProductDto(String id, int brandId, int categoryId, String name, String size, String color, int volume) {
        Id = id;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.name = name;
        this.size = size;
        this.color = color;
        this.volume = volume;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
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
                "Id='" + Id + '\'' +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", volume=" + volume +
                '}';
    }
}
