package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.LoginDto;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    LoginDto loginValidation(@Param("id") String id,@Param("password") String password);
}
