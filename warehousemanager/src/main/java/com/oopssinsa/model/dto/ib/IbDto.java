package com.oopssinsa.model.dto.ib;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class IbDto {
    private String id;
    private LocalDate manufactureDate;
    private String productId;
    private String brandId;
    private int quantity;
    private LocalDate ibRequestDate;
    private LocalDate ibDate;
    private char status;
}
