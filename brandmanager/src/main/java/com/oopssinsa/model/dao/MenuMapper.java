package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;
import com.oopssinsa.model.dto.ProductDto;

public interface MenuMapper {
    int insertProduct(ProductDto productDto);

    int ibRequest(IbDetailDto ibDetailDto);

    AccountDto login(String login);
}
