package com.oopssinsa.model.dao;


import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObMapper {

    List<ObRequestDto> findObByRequestState();

    List<ObDto> findAllOb();

    List<StockDto> findAllStock();

    List<StockDto> findStockOrderableByProductId(@Param("productId") String productId);

    List<ObRequestAndStockDto> findObRequestAndStock();

    int updateStock(StockDto stockDto);

    int insertObDetails(ObDetailDto obDetailDto);

    int updateObState(ObDetailDto obDetailDto);

    List<ObDetailDto> findObDetailByWaitingState();

    int insertObWorker(InstructionDto instructionDto);
}
