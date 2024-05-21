package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.AccountMapper;
import com.oopssinsa.model.dto.AccountDto;
import org.apache.ibatis.session.SqlSession;



public class AccountService {

    // 나경 작업 시작
    public AccountDto findAccountById(String id ,String password) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

        return accountMapper.findAccountById(id, password, "WM");

    }
}

    // 나경 작업 끝

//public class AccountService {
//
//    public AccountDto findAccountById(String id) {
//        return new AccountDto(id, "1234567a!", "WM");
//
//    }
//    public static void displayLoginResult(boolean result, String id) {
//    }
//
//    public boolean loginValidation(String id, String password){
//        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
//        AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);
//        AccountDto accountDto = accountMapper.loginValidation(id, password);
//        if(accountDto==null || accountDto.getId()==null || accountDto.getPassword()==null){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
//}
