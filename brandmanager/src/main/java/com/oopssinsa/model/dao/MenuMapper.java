package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int insertProduct(ProductDto productDto);

    int ibRequest(IbDetailDto ibDetailDto);

    AccountDto login(@Param("id") String id, @Param("password") String password);

    List<IbDetailDto> findByUserID(String id);

    int obRequest(ObDetailDto obDetailDto);

    List<ProductDto> showProduct(long brandId);

    List<ObDto> findObDetail(String userId);

    List<StockListDto> findAllStockDetail(long brandId);
}
