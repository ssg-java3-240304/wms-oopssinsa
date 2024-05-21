package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.IbMapper;
import com.oopssinsa.model.dao.ObMapper;
import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.dto.ObDto;
import com.oopssinsa.model.dto.ObInstructionDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ObService {
    /*
    <getObInstructionToDo>
    출고 요청 테이블에서 workerId와 동일한 작업자에게 요청된 출고요청 중 현재 상태가 "P"인 요청을 모두 반환한다.
     */
    public List<ObInstructionDto> getObInstructionToDo(String workerId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        List<ObInstructionDto> obInstructions = obMapper.getObInstructionToDo(workerId);
//        System.out.println(obInstructions);
        return obInstructions;
    }

    /*
    <updateObStatus>
    updateOb에 담겨 전달된 입고id, 상품id, 제조일자를 통해 DB에서 특정 입고 요청을 찾고 해당 출고요청을 updateOb에 담긴
    status로 갱신한다.
    (아마 재귀쿼리로 처리해야 할 듯 합니다.)
     */
    public void updateObStatus(ObDto updateOb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        obMapper.updateObStatus(updateOb);
        sqlSession.commit();
        sqlSession.close();
    }

    /*
    <findOb>
    targetOb에 담겨서 전달된 입고id, 상품id, 제조일자를 통해 DB에서 동일한 입고 요청을 찾아 반환한다.
    */
    public ObDto findOb(ObDto targetOb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findOb(targetOb);
    }

    /*
    <findIbInstruction>
    obInstructionDto에 담겨 전달된 출고id, 상품id, 제조일자로 특정 출고 요청을 찾아 반환한다.
    위치별 용량 업데이트를 위해 추가했습니다.
     */
    public ObInstructionDto findObInstruction(ObInstructionDto obInstructionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findObInstruction(obInstructionDto);
    }

    // 예진 작업 시작
    public int findProductVolume(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        return obMapper.findProductVolume(productId);
    }

    public Integer findTrackingNumber(long obId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        Integer trackingNumber = obMapper.findTrackingNumber(obId);
        return trackingNumber;
    }

    public int insertTrackingNumber(long obId, Integer trackingNumber) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        ObMapper obMapper = sqlSession.getMapper(ObMapper.class);
        int result = obMapper.insertTrackingNumber(obId, trackingNumber);
        return result;
    }

    public long findProductLocation(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findProductLocation(productId);
    }

    // 예진 작업 끝
}