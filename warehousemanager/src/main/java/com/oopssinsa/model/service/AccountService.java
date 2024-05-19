package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.AccountDto;

public class AccountService {
    public AccountDto findAccountById(String id) {
        return new AccountDto(id, "1234567a!", "WM");
    }

}
