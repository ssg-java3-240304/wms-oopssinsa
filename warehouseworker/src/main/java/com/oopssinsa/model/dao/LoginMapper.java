package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.LoginDto;

public interface LoginMapper {
    LoginDto loginValidation(String id, String password);
}
