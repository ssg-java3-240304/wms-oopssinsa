package com.oopssinsa.view;

import com.oopssinsa.model.dto.WorkerDto;
import java.util.List;

public class WorkerView {
    public void printWorker(List<WorkerDto> workerDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(30) + "+");
        System.out.println("| 번호 |  작업자ID  | 이름 | 상태 |");
        System.out.println("|" + "-".repeat(30) + "|");
//        System.out.println("작업자ID" + "  " + "이름" + "  " + "상태");
        for (WorkerDto workerDto : workerDtos) {
            System.out.printf("|%5d| %7s| %5s| %4c|\n",
                    (count++), workerDto.getId(), workerDto.getName(), workerDto.getState());
//            System.out.println(
//                    (count++) + ". " + workerDto.getId() + "  " + workerDto.getName() + "  " + workerDto.getState());
        }
        System.out.println("+" + "-".repeat(30) + "+\n");
    }
}
