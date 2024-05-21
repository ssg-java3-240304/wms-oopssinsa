package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.IbMapper;
import com.oopssinsa.model.dto.ib.IbDto;
import com.oopssinsa.model.dto.ib.IbRequestAndLocationDto;
import com.oopssinsa.model.dto.LocationDto;
import com.oopssinsa.model.dto.ProductDto;
import com.oopssinsa.model.dto.SectionDto;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class IbService {
    public int updateIbState(IbDto updateIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        try {
            int result = ibMapper.updateIbState(updateIb);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateExpectedCapacityLocation(LocationDto locationDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        try {
            int result = ibMapper.updateExpectedCapacityLocation(locationDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateExpectedCapacitySection(SectionDto sectionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        try {
            int result = ibMapper.updateExpectedCapacitySection(sectionDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public LocationDto findLocationByCategoryIdAndSectionId(String categoryId, char sectionId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findLocationByCategoryIdAndSectionId(categoryId, sectionId);
    }

    public ProductDto findProductByProductId(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findProductByProductId(productId);
    }

    public SectionDto findSectionByBrandId(String brandId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findSectionByBrandId(brandId);
    }

    public List<IbDto> findAllIb() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findAllIb();
    }

    public List<IbDto> findIbByRequestState() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIbByRequestState();
    }

    public List<IbDto> findIbByWaitingState() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIbByWaitingState();
    }

    public List<IbRequestAndLocationDto> findIbRequestAndLocation(List<IbDto> ibDtos) {
        try {
            SqlSession sqlSession = MyBatisTemplate.getSqlSession();
            IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
            return ibMapper.findIbRequestAndLocation(ibDtos);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
