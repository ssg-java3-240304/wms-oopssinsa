//package com.oopssinsa.model.service;
//
//import com.oopssinsa.model.dto.InstructionDto;
//import com.oopssinsa.model.dto.WorkerDto;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WorkerService {
//    public int insertIbWorker(InstructionDto instructionDto) {
//        return 1;
//    }
//
//    public int updateWorkerStatus(WorkerDto workerDto) {
//        return 1;
//    }
//
//    public List<WorkerDto> findWorkerByAssignableStatus() {
//        List<WorkerDto> workerDtos = new ArrayList<>();
//        workerDtos.add(new WorkerDto("worker_id1", "name1", 'T'));
//        workerDtos.add(new WorkerDto("worker_id2", "name2", 'T'));
////        workerDtos.add(new WorkerDto("worker_id3", "name3", 'F'));
//        return workerDtos;
//    }
//
//    public List<WorkerDto> findAllWorker() {
//        List<WorkerDto> workerDtos = new ArrayList<>();
//        workerDtos.add(new WorkerDto("worker_id1", "name1", 'T'));
//        workerDtos.add(new WorkerDto("worker_id2", "name2", 'T'));
//        workerDtos.add(new WorkerDto("worker_id3", "name3", 'F'));
//        workerDtos.add(new WorkerDto("worker_id4", "name4", 'F'));
//        return workerDtos;
//    }
//}

package com.oopssinsa.model.service;

import com.oopssinsa.common.MyBatisTemplate;
import com.oopssinsa.model.dao.WorkerMapper;
import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.WorkerDto;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkerService {
    public int insertIbWorker(InstructionDto instructionDto) {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            return workerMapper.insertIbWorker(instructionDto);
        }
    }

    public int updateWorkerStatus(WorkerDto workerDto) {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            return workerMapper.updateWorkerStatus(workerDto);
        }
    }

    public List<WorkerDto> findWorkerByAssignableStatus() {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            return workerMapper.findWorkerByAssignableStatus();
        }
    }

    public List<WorkerDto> findAllWorker() {
        try (SqlSession sqlSession = MyBatisTemplate.getSqlSession()) {
            WorkerMapper workerMapper = sqlSession.getMapper(WorkerMapper.class);
            return workerMapper.findAllWorker();
        }
    }
}