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
    public void updateIbState(IbDto updateIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        ibMapper.updateIbState(updateIb);
    }

    public int updateExpectedCapacityLocation(LocationDto locationDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.updateExpectedCapacityLocation(locationDto);
    }

    public int updateExpectedCapacitySection(SectionDto sectionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.updateExpectedCapacitySection(sectionDto);
    }


    public LocationDto findLocationByCategoryIdAndSectionId(String categoryId, char sectionId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findLocationByCategoryIdAndSectionId(categoryId, sectionId);
    }

    public ProductDto findProductByProductId(String productID) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findProductByProductId(productID);
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

    public List<IbDto> findIbByRequestState(){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIbByRequestState();
    }

    public List<IbDto> findIbByWaitingState(){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIbByWaitingState();
    }


    public List<IbRequestAndLocationDto> findIbRequestAndLocation(List<IbDto> ibDtos) {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
            return ibMapper.findIbRequestAndLocation(ibDtos);
        }
    }



//    // 진행중 쿼리 테스트중
//    // 입고리스트에서 상품id-> 브랜드 id -> 구역 id ->  + 상품id-> 카테고리 id
//    public List<LocationDto> findLocationsByIbDtos(List<IbDto> ibDtos) {
//        List<LocationDto> locationDtos = new ArrayList<>();
//        locationDtos.add(new LocationDto("location_id1", 'A', "category_id1",
//                3, 0, 10));
//        locationDtos.add(new LocationDto("location_id2", 'B', "category_id1",
//                3, 0, 13));
//        return locationDtos;
//    }

    // findLocationsByIbDtos() -> findIbRequestAndLocation 로변경
    // ibDtos를 받으면 상품id-> 브랜드 id -> 구역 id ->  + 상품id-> 카테고리 id 을 통해서 각 입고1개당 구역을 연결시켜줘서 반환해야 함
    // 입고 가능상태도 계산하여 행에 추가해줘야함
    // 상품 리스트 인자로 주면 하위 위치에 ........ 하위위치 상품하나당 하위위치하나

}
