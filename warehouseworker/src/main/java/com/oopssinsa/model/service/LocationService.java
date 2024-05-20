package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.LocationMapper;
import com.oopssinsa.model.dto.SubLocationDto;
import org.apache.ibatis.session.SqlSession;

public class LocationService {
    /*
    <getCurrentCapacity>
    전달받은 targetLocationId와 동일한 Id의 location의 현재 용량을 반환한다.
    이건 Dto 사용 안했습니다.
     */
    public int getCurrentCapacity(long targetLocationId){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
        return locationMapper.getCurrentCapacity(targetLocationId);
    }
    /*
    <updateCurrentCapacity>
    subLocationDto에 담겨 전달된 sublocationId와 같은 id를 갖는 위치의 재고 현황을
    subLocationDto에 담겨 전달된 currentCapacity로 업데이트한다.
     */
    public void updateCurrentCapacity(SubLocationDto subLocationDto){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
        locationMapper.updateCurrentCapacity(subLocationDto);
        sqlSession.commit();
        sqlSession.close();
    }
}
