package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.LoginMapper;
import com.oopssinsa.model.dto.LoginDto;
import org.apache.ibatis.session.SqlSession;

public class LoginService {
    /*
    <loginValidation>
    전달받은 id와 password를 통해 로그인 테이블에서 id와 password가 동시에 동일한 레코드를 찾아 반환한다.
    null처리 통해 로그인 실패는 구현해 두었습니다.
     */
    public boolean loginValidation(String id, String password){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        LoginMapper loginMapper = sqlSession.getMapper(LoginMapper.class);
        LoginDto loginDto = loginMapper.loginValidation(id, password);
        if(loginDto==null || loginDto.getId()==null || loginDto.getPassword()==null){
            return false;
        }
        else{
            return true;
        }
    }
}
