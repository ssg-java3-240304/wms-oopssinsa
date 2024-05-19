package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.IbDto;
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
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

//    @Disabled
//    @ParameterizedTest
//    @MethodSource("ibDto")
//    void findIb(IbDto ibDto) {
//        IbDto ibDto1 = ibMapper.findIb(ibDto);
//        assertThat(ibDto1).isNotNull();
//
//    }
//    public static Stream<IbDto> ibDto() {
//        LocalDate localDate = LocalDate.of(24,5,1);//For reference
//        IbDto ibDto = new IbDto(202405181, localDate, "UA001", 0, null, "");
//        return Stream.of(ibDto);
//    }
    @Disabled
    @Test
    void test1() {
        LocalDate localDate = LocalDate.of(2024,5,18);//For reference
        IbDto ibDto = new IbDto(1, localDate, "BG005", 0, null, "");
        assertThat(ibMapper.findIb(ibDto)).isNotNull();
        System.out.println(ibMapper.findIb(ibDto));
    }

    @Test
    void test2() {
        assertThat(ibMapper.findProductVolume("BG003")).isEqualTo(6);
    }


}