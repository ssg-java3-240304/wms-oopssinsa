package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.ObInstructionDto;
import com.oopssinsa.model.service.ObService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.junit.jupiter.api.Assertions.*;

class ObMapperTest {

    SqlSession sqlSession;
    ObMapper obMapper;
    ObService obService;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.obMapper = sqlSession.getMapper(ObMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    /*
    <getObInstructionToDo>
    출고 요청 테이블에서 workerId와 동일한 작업자에게 요청된 출고요청 중 현재 상태가 "R"인 요청을 모두 반환한다.
     */

    // 출고요청 더미 데이터가 없어서 테스트 못함..

    @Test
    void getObIntructionToDo() {
        //given
        String workerId = "worker01";
        //then
        List<ObInstructionDto> test = obService.getObInstructionToDo(workerId);

        //when

    }

    /*
    <updateObStatus>
    updateOb에 담겨 전달된 출고id, 상품id, 제조일자를 통해 DB에서 특정 출고 요청을 찾고 해당 출고요청을 updateOb에 담긴 status로 갱신한다.
    - findOb 출고 요청 조회를 먼저 해야 테스트 가능
    */

    @Test
    void updateObStatus() {

    }

    @Test
    void findOb() {
    }

    @Test
    void findObInstruction() {
    }

    @Test
    void findProductVolume() {
    }
}