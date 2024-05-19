package com.oopssinsa.model.dto;

// 지시 때 받은 locationId로 현재용량 변경
// locationId를 통해 브랜드와 카테고리를 알 수 있다
// 용량은 부피가 필요함, 부피*수량을 입고시 더하고, 출고시 뺀다.
// 구역 용량 변경을 염두해둘것
public class SubLocationDto {
    private long id;
    private int currentCapacity;
    private int expectedCapacity; // + - 수량만 넣습니다.

    public SubLocationDto(long id, int currentCapacity, int expectedCapacity) {
        this.id = id;
        this.currentCapacity = currentCapacity;
        this.expectedCapacity = expectedCapacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
