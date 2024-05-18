package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.dto.ObInstructionDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ObService {
    public List<ObInstructionDto> getObInstructionToDo(String workerId) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        List<ObInstructionDto> obInstructions = workerMapper.getObIntructionToDo(workerId);
        return obInstructions;
    }
}
