package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;

public interface StockMapper {
    void insertStockHistory(StockHistoryDto stockHistoryDto);

    void updateStock(StockDto updateStock);

    StockDto findStock(StockDto targetStock);
}
