package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbDatailDto;
import com.oopssinsa.model.dto.ProductDto;

public interface MenuMapper {
    int insertProduct(ProductDto productDto);

    int ibRequest(IbDatailDto ibDatailDto);
}
