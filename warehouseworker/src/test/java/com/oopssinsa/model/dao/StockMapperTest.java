package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static com.oopssinsa.common.MyBatisTemplate.getSqlSession;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StockMapperTest {
    SqlSession sqlSession;
    StockMapper stockMapper;

    @BeforeEach
    void setUp() {
        this.sqlSession = getSqlSession();
        this.stockMapper = sqlSession.getMapper(StockMapper.class);
    }

    @AfterEach
    void tearDown() {
        this.sqlSession.commit();
//        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Test
    void insertStockHistory() {
        LocalDate localDate = LocalDate.of(2024, 5, 18);
        StockHistoryDto stockHistoryDto = new StockHistoryDto(localDate, "", 0, LocalDate.now());
        assertThat(stockMapper.insertStockHistory(stockHistoryDto)).isEqualTo(1);
    }

    @Test
    void updateStock() {
    }

    @Test
    void findStock() {
    }
}