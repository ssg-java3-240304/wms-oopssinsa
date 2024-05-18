package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;
import org.apache.ibatis.session.SqlSession;

public class StockService {

    public StockDto findStock(StockDto targetStock){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        return workerMapper.findStock(targetStock);
    }
    public void updateStock(StockDto updateStock){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        workerMapper.updateStock(updateStock);
    }

    public void insertStockHistory(StockHistoryDto stockHistoryDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        workerMapper.insertStockHistory(stockHistoryDto);
    }
}
