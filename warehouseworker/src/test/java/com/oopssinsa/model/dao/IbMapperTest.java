package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbInstructionDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IbMapperTest {
    SqlSession sqlSession;
    IbMapper ibMapper;
    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.ibMapper = sqlSession.getMapper(IbMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit();
        this.sqlSession.rollback();
        this.sqlSession.close();
    }
    @Disabled
    @Test
    void findIb() {
        LocalDate localDate = LocalDate.of(2024,5,18);//For reference
        IbDto ibDto = new IbDto(1, localDate, "BG005", 0, null, "");
        assertThat(ibMapper.findIb(ibDto)).isNotNull();
        System.out.println(ibMapper.findIb(ibDto));
    }

    @Test
    void findProductVolume() {
        assertThat(ibMapper.findProductVolume("BG003")).isEqualTo(6);
    }

    @Disabled
    @Test
    void getIbInstructionToDo() {
        List<IbInstructionDto> getIbInstructionToDo = ibMapper.getIbInstructionToDo("worker1");
        assertThat(getIbInstructionToDo).isNotNull();
        System.out.println(getIbInstructionToDo);
    }

    @Disabled
    @Test
    void updateIbStatus(){
        LocalDate localDate = LocalDate.of(2024,5,17);
        IbDto ibDto = ibMapper.findIb(new IbDto(3, localDate, "JK001", 0,null,"P"));
        assertThat(ibMapper.updateIbStatus(ibDto)).isEqualTo(1);
    }


}