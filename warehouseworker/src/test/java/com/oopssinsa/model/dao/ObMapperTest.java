package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObInstructionDto;
import com.oopssinsa.model.service.ObService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ObMapperTest {

    SqlSession sqlSession;
    ObMapper obMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.obMapper = sqlSession.getMapper(ObMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
//        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    /*
    <getObInstructionToDo>
    출고 요청 테이블에서 workerId와 동일한 작업자에게 요청된 출고요청 중 현재 상태가 "P"인 요청을 모두 반환한다.
     */

    // 출고요청 더미 데이터가 없어서 테스트 못함..

    @Disabled
    @Test
    void getObInstructionToDo() {
        //given
        String workerId = "worker2";
        //then
        List<ObInstructionDto> test = obMapper.getObInstructionToDo(workerId);
        assertThat(test).isNotNull().isNotEmpty();
        //when
        System.out.println(test);
    }

    /*
    <updateObStatus>
    updateOb에 담겨 전달된 출고id, 상품id, 제조일자를 통해 DB에서 특정 출고 요청을 찾고 해당 출고요청을 updateOb에 담긴 status로 갱신한다.
    - findOb 출고 요청 조회를 먼저 해야 테스트 가능
    */

    @Disabled
    @Test
    void updateObStatus() {
        LocalDate localDate = LocalDate.of(2023, 8, 23);
        ObDto obDto = new ObDto(4240521, localDate, "BG003", 1, null, "F", 0);
        System.out.println(obDto);
        int result = obMapper.updateObStatus(obDto);
        assertThat(result).isEqualTo(1);
//        System.out.println(result);
    }

    @Disabled
    @Test
    void findOb() {
        LocalDate localDate = LocalDate.of(2023, 7, 21);
        ObDto obDto = new ObDto(3240521, localDate, "JK003", 1, null, "P", 0);
        obDto = obMapper.findOb(obDto);
        System.out.println(obDto);
        assertThat(obDto).isNotNull();
    }

    @Test
    void findObInstruction() {
        LocalDate localDate = LocalDate.of(2023, 7, 21);
        ObInstructionDto obInstructionDto = new ObInstructionDto(3240521, localDate, "JK003", null);
        obInstructionDto = obMapper.findObInstruction(obInstructionDto);
        System.out.println(obInstructionDto);
        assertThat(obInstructionDto).isNotNull();
    }

    @Test
    void findProductVolume() {
        assertThat(obMapper.findProductVolume("JK003")).isEqualTo(2);
    }

//    @Disabled
    @Test
    void insertTrackingNumber() {
        int result = obMapper.insertTrackingNumber(1, 35);
        assertThat(result).isEqualTo(1);
    };

//    @Disabled
    @Test
    void findTrackingNumber(){
        Integer trackingNumber = obMapper.findTrackingNumber(1);
        assertThat(trackingNumber).isEqualTo(35);
    };
}
