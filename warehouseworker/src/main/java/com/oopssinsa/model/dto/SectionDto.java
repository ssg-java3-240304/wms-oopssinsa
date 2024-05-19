package com.oopssinsa.model.dto;

// 이건 그냥 location이 변경됐을 때 location에서 얻어온 sumOfSection으로 업데이트하기
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

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getExpectedCapacity() {
        return expectedCapacity;
    }

    public void setExpectedCapacity(int expectedCapacity) {
        this.expectedCapacity = expectedCapacity;
    }
}
