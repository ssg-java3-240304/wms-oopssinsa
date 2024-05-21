package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface MenuMapper {
    int insertProduct(ProductDto productDto);

    int ibRequest(IbDetailDto ibDetailDto);

    AccountDto login(@Param("id") String id, @Param("password") String password);

    List<IbDetailDto> findByUserID(String id);

    int obRequest(ObDetailDto obDetailDto);

    List<ProductDto> showProduct(long brandId);

    List<ObDto> findObDetail(String userId);

    List<StockListDto> findAllStockDetail(long brandId);

    List<StockListDto> findStockByCategoryId(Map<String, Object> param);

    List<StockListDto> findStockByProductId(Map<String, Object> param);
}
