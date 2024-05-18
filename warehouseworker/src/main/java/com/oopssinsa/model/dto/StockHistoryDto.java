package com.oopssinsa.model.dto;

import java.time.LocalDate;

public class StockHistoryDto {
    private long manufactureId;
    private long productId;
    private String quantity; // - or +
    private LocalDate date; // 처리시각
}
