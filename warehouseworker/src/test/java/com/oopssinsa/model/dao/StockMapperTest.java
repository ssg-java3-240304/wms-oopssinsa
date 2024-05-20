package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
//        this.sqlSession.commit();
        this.sqlSession.rollback();
        this.sqlSession.close();
    }

    @Disabled
    @Test
    void insertStockHistory() {
        LocalDate localDate = LocalDate.of(2024, 5, 18);
        StockHistoryDto stockHistoryDto = new StockHistoryDto(localDate, "", 0, LocalDate.now());
        assertThat(stockMapper.insertStockHistory(stockHistoryDto)).isEqualTo(1);
    }
    @Disabled
    @Test
    void updateStock() {
        LocalDate localDate = LocalDate.of(2023, 2, 1);
        StockDto stockDto = new StockDto("JK004", localDate, 15, 161, 3);
        int result = stockMapper.updateStock(stockDto);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void findStock() {
        LocalDate localDate = LocalDate.of(2023, 2, 1);
        StockDto stockDto = new StockDto("JK004", localDate, 0, 0, 0);
        stockDto = stockMapper.findStock(stockDto);
        assertThat(stockDto).isNotNull();
        System.out.println(stockDto);
    }
}