package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;

import java.util.List;

public interface ObMapper {

    List<ObRequestDto> findObByRequestState();

    List<ObDto> findAllOb();

    List<StockDto> findAllStock();

    List<StockDto> findStockOrderableByProductId(String productId);

    List<ObRequestAndStockDto> findObRequestAndStock();

    int updateStock(StockDto stockDto);

    int insertObDetails(List<ObDetailDto> obDetailDtos);

    int updateObState(ObDetailDto obDetailDto);

    List<ObDetailDto> findObDetailByWaitingState();

    int insertObWorker(InstructionDto instructionDto);
}
