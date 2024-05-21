package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;

public interface StockMapper {
    int insertStockHistory(StockHistoryDto stockHistoryDto);

    int updateStock(StockDto updateStock);

    StockDto findStock(StockDto targetStock);

    int insertStock(StockDto stockDto);
}
