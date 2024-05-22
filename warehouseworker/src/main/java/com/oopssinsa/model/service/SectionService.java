package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.LocationMapper;
import com.oopssinsa.model.dao.ObMapper;
import org.apache.ibatis.session.SqlSession;

public class SectionService {
    public void updateSectionCurrentCapacity(long locationId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        LocationMapper locationMapper = sqlSession.getMapper(LocationMapper.class);
        int result = locationMapper.updateSectionCurrentCapacity(locationId);
        if (result == 1)
            sqlSession.commit();
        sqlSession.close();
    }
}
