package com.oopssinsa.model.service;

import com.oopssinsa.model.dto.InstructionDto;
import com.oopssinsa.model.dto.WorkerDto;
import java.util.ArrayList;
import java.util.List;

public class WorkerService {
    public int insertIbWorker(InstructionDto instructionDto) {
        return 1;
    }

    public int updateWorkerStatus(WorkerDto workerDto) {
        return 1;
    }

    public List<WorkerDto> findWorkerByAssignableStatus() {
        List<WorkerDto> workerDtos = new ArrayList<>();
        workerDtos.add(new WorkerDto("worker_id1", "name1", 'T'));
        workerDtos.add(new WorkerDto("worker_id2", "name2", 'T'));
//        workerDtos.add(new WorkerDto("worker_id3", "name3", 'F'));
        return workerDtos;
    }
}
