package com.oopssinsa.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// 입고처리내역
// 작업자는 입고ID, 상품ID, 제조일자를 통해 입고완료일자와 입고처리상태를 바꾼다
// ibId와 productId와 manufactureId를 통해 요청 수량을 얻는다.
@Setter
@Getter
@NoArgsConstructor
public class IbDto {
    private long id;
    private LocalDate manufactureId;
    private String productId;
    private int quantity;
    private LocalDate completionDate;
    private String status;

    public IbDto(long id, LocalDate manufactureId, String productId, int quantity, LocalDate completionDate, String status) {
        this.id = id;
        this.manufactureId = manufactureId;
        this.productId = productId;
        this.quantity = quantity;
        this.completionDate = completionDate;
        this.status = status;
    }

    @Override
    public String toString() {
        return "IbDto{" +
                "id=" + id +
                ", manufactureId=" + manufactureId +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", completionDate=" + completionDate +
                ", status='" + status + '\'' +
                '}';
    }
}
