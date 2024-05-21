package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.AccountDto;

public interface AccountMapper {
    AccountDto loginValidation(String id, String password);
}
