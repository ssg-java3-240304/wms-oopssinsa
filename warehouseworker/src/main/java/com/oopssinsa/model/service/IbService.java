package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.IbMapper;
import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.dto.StockDto;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IbService {

    /*
    <findIb>
    targetIb에 담겨서 전달된 입고id, 상품id, 제조일자를 통해 DB에서 동일한 입고 요청을 찾아 반환한다.
    */
    public static IbDto findIb(IbDto targetIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIb(targetIb);
    }

    /*
    <getIbInstructionToDo>
    입고 요청 테이블에서 workerId와 동일한 작업자에게 요청된 입고요청 중 현재 상태가 "R"인 요청을 모두 반환한다.
     */
    public List<IbInstructionDto> getIbInstructionToDo(String workerId){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.getIbInstructionToDo(workerId);
    }

    /*
    <updateIbStatus>
    updateIb에 담겨 전달된 입고id, 상품id, 제조일자를 통해 DB에서 특정 입고 요청을 찾고 해당 입고요청을 updateIb에 담긴
    status로 갱신한다.
    (아마 재귀쿼리로 처리해야 할 듯 합니다.)
     */
    public void updateIbStatus(IbDto updateIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        ibMapper.updateIbStatus(updateIb);
        sqlSession.commit();
//        sqlSession.rollback();
        sqlSession.close();
    }

    /*
    <findIbInstruction>
    ibInstructionDto에 담겨 전달된 입고id, 상품id, 제조일자로 특정 입고 요청을 찾아 반환한다.
    위치별 용량 업데이트를 위해 추가했습니다.
     */
    public IbInstructionDto findIbInstruction(IbInstructionDto ibInstructionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findIbInstruction(ibInstructionDto);
    }

    public int findProductVolume(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findProductVolume(productId);
    }

    public long findProductLocation(String productId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        IbMapper ibMapper = sqlSession.getMapper(IbMapper.class);
        return ibMapper.findProductLocation(productId);
    }
}
