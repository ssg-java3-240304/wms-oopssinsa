package com.oopssinsa.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InstructionDto {
    private String id;
    private LocalDate manufactureDate;
    private String productId;
    private String workerId;
}
