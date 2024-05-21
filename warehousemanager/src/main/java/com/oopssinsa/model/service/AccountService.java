package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.AccountMapper;
import com.oopssinsa.model.dto.AccountDto;
import org.apache.ibatis.session.SqlSession;

public class AccountService {

    // 나경 작업 시작
    public AccountDto findAccountById(String id) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        return accountMapper.findAccountById(id);

    }
}


