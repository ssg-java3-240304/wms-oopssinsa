package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.AccountDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;


class AccountMapperTest {

    SqlSession sqlSession;
    AccountMapper accountMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.accountMapper = sqlSession.getMapper(AccountMapper.class);

    }

    @AfterEach
    void tearDown() {
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    void findAccountById() {

        AccountDto accountDto = accountMapper.findAccountById("user08");
        System.out.println(accountDto);

    }
}