package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.ObMapper;
import org.apache.ibatis.session.SqlSession;
import com.oopssinsa.model.dto.ob.ObDetailDto;
import com.oopssinsa.model.dto.ob.ObDto;
import com.oopssinsa.model.dto.ob.ObRequestAndStockDto;
import com.oopssinsa.model.dto.ob.ObRequestDto;
import com.oopssinsa.model.dto.StockDto;
import java.util.List;

public class ObService {
    public List<ObRequestDto> findObByRequestState() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findObByRequestState();
    }

    public List<ObDto> findAllOb() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findAllOb();

    }

    public List<StockDto> findAllStock() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findAllStock();

    }

    public List<StockDto> findStockOrderableByProductId(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findStockOrderableByProductId(productId);

    }

    public List<ObRequestAndStockDto> findObRequestAndStock() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findObRequestAndStock();
    }

    public int updateStock(StockDto stockDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        try {
            int result = obMapper.updateStock(stockDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int insertObDetails(List<ObDetailDto> obDetailDtos) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        try {
            int sum = 0;
            for (ObDetailDto obDetailDto : obDetailDtos) {
                sum += obMapper.insertObDetails(obDetailDto);
            }
//            return obMapper.insertObDetails(obDetailDtos);
            return (sum == obDetailDtos.size() ? 1 : 0);
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateObState(ObDetailDto obDetailDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        try {
            int result = obMapper.updateObState(obDetailDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<ObDetailDto> findObDetailByWaitingState() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findObDetailByWaitingState();
    }
}
