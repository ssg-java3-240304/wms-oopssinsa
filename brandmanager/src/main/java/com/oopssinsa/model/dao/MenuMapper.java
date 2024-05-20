package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ProductDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    int insertProduct(ProductDto productDto);

    int ibRequest(IbDetailDto ibDetailDto);

    AccountDto login(@Param("id") String id, @Param("password") String password);

    List<IbDetailDto> findByUserID(String id);
}
