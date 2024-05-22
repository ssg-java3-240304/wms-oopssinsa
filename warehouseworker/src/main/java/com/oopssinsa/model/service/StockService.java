package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.StockMapper;
import com.oopssinsa.model.dto.StockDto;
import com.oopssinsa.model.dto.StockHistoryDto;
import org.apache.ibatis.session.SqlSession;

public class StockService {

    /*
    <findStock>
    targetStock에 담겨 전달된 상품id, 제조일자를 통해 DB에서 특정 재고 현황을 찾아 반환한다.
     */
    public StockDto findStock(StockDto targetStock){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
        return stockMapper.findStock(targetStock);
//        sqlSession.close();
    }
    /*
    <updateStock>
    updateStock에 담겨 전달되는 상품id와 제조일자를 통해 특정 재고 현황을 찾아 updateStock에 담겨 전달되는
    quantity와 expectedQuantity로 업데이트한다.
     */
    public void updateStock(StockDto updateStock){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
        int result = stockMapper.updateStock(updateStock);
        if (result == 1)
            sqlSession.commit();
        sqlSession.close();
    }

    /*
    <insertStockHistory>
    stockHistory에 담겨온 정보 그대로 재고 변동 내역 테이블에 추가한다.
     */
    public void insertStockHistory(StockHistoryDto stockHistoryDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
        int result = stockMapper.insertStockHistory(stockHistoryDto);
        if (result == 1)
           sqlSession.commit();
        sqlSession.close();
    }

    public void insertStock(StockDto stockDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
        int result = stockMapper.insertStock(stockDto);
        if (result == 1)
            sqlSession.commit();
        sqlSession.close();
    }
}
