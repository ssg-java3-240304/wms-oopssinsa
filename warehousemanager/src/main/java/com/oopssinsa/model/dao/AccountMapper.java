package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.AccountDto;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

    AccountDto findAccountById(@Param("id") String id, @Param("password") String password,@Param("role") String role);

}
