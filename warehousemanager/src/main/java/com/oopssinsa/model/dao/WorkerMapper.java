package com.oopssinsa.model.dao;

import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.WorkerDto;

import java.util.List;

public interface WorkerMapper {
    int insertIbWorker(InstructionDto instructionDto);

    int updateWorkerStatus(WorkerDto workerDto);

    List<WorkerDto> findWorkerByAssignableStatus();

    List<WorkerDto> findAllWorker();

    int insertObWorker(InstructionDto instructionDto);
}
