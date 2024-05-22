package com.oopssinsa.view;

import com.oopssinsa.model.dto.WorkerDto;
import java.util.List;

public class WorkerView {

    private final InputView inputView;

    public WorkerView() {
        this.inputView = new InputView();
    }

    public int getWorkerIndex() {
        System.out.println("배정할 작업자를 선택해 주세요.");
        return inputView.getNumber() - 1;
    }

    public void printAllWorker(List<WorkerDto> workerDtos) {
        printWorker(workerDtos);
    }

    public void printAssignableWorker(List<WorkerDto> workerDtos) {
        System.out.println("배정 가능한 작업자 목록");
        printWorker(workerDtos);
    }

    private void printWorker(List<WorkerDto> workerDtos) {
        int count = 1;
        System.out.println("+" + "-".repeat(32) + "+");
        System.out.println("| 번호 |  작업자ID  |  이름  | 상태 |");
        System.out.println("|" + "-".repeat(32) + "|");
        for (WorkerDto workerDto : workerDtos) {
            System.out.printf("|%5d| %10s| %5s| %4c|\n",
                    (count++), workerDto.getId(), workerDto.getName(), workerDto.getStatus());
        }
        System.out.println("+" + "-".repeat(32) + "+\n");
    }
}
