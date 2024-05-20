package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.SubLocationDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LocationMapperTest {
    SqlSession sqlSession;
    LocationMapper locationMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.locationMapper = sqlSession.getMapper(LocationMapper.class);
    }

    @AfterEach
    void tearDown() {
//        this.sqlSession.commit();
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    void getCurrentCapacity() {
        int capacity = locationMapper.getCurrentCapacity(71);
        assertThat(capacity).isEqualTo(840);

    }

    @Disabled
    @Test
    void updateCurrentCapacity() {
        SubLocationDto subLocationDto = new SubLocationDto(71, 841, 0);
        int result = locationMapper.updateCurrentCapacity(subLocationDto);
        assertThat(result).isEqualTo(1);
    }
}