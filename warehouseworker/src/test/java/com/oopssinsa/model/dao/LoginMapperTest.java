package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.LoginDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.junit.jupiter.api.Assertions.*;

class LoginMapperTest {

    SqlSession sqlSession;
    LoginMapper loginMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.loginMapper = sqlSession.getMapper(LoginMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Disabled
    @Test
    void loginValidation() {
        LoginDto loginDto = loginMapper.loginValidation("worker1", "password654");
        System.out.println(loginDto);
    }
}