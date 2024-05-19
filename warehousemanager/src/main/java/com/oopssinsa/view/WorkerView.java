package com.oopssinsa.view;

import com.oopssinsa.model.dto.WorkerDto;
import java.util.List;

public class WorkerView {
    public void printAssignableWorker(List<WorkerDto> workerDtos) {
        int count = 1;
        System.out.println("작업자ID" + "  " + "이름" + "  " + "상태");
        for (WorkerDto workerDto : workerDtos) {
            System.out.println(
                    (count++) + ". " + workerDto.getId() + "  " + workerDto.getName() + "  " + workerDto.getState());
        }
        System.out.println();
    }
}
