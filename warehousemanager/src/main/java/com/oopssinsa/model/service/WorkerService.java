package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.WorkerDto;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class WorkerService {
    public int insertIbWorker(InstructionDto instructionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        try {
            int result = workerMapper.insertIbWorker(instructionDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int insertObWorker(InstructionDto instructionDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        try {
            int result = workerMapper.insertObWorker(instructionDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int updateWorkerStatus(WorkerDto workerDto) {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        try {
            int result = workerMapper.updateWorkerStatus(workerDto);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public List<WorkerDto> findWorkerByAssignableStatus() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        return workerMapper.findWorkerByAssignableStatus();
    }

    public List<WorkerDto> findAllWorker() {
        SqlSession sqlSession = MyBatisTemplate.getSqlSession();
        WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
        return workerMapper.findAllWorker();
    }
}