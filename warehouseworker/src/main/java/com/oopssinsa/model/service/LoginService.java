package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.LoginDto;
import org.apache.ibatis.session.SqlSession;

public class LoginService {
    public boolean loginValidation(String id, String password){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        LoginDto loginDto = workerMapper.loginValidation(id, password);
        if(loginDto==null || loginDto.getId()==null || loginDto.getPassword()==null){
            return false;
        }
        else{
            return true;
        }
    }
}
