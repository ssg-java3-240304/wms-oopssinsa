package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.IbDto;
import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.dto.StockDto;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class IbService {
    public static IbDto findIb(IbDto targetIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        return workerMapper.findIb(targetIb);
    }

    public List<IbInstructionDto> getIbInstructionToDo(String workerId){
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        return workerMapper.getIbInstructionToDo(workerId);
    }

    public void updateIbStatus(IbDto updateIb) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        workerMapper.updateIbInstruction(updateIbInstruction);
    }
}
