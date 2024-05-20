package com.oopssinsa.controller;

import com.oopssinsa.model.service.WorkerService;
import com.oopssinsa.view.WorkerView;

public class WorkerController {
    private final WorkerService workerService;
    private final WorkerView workerView;

    public WorkerController() {
        this.workerService = new WorkerService();
        this.workerView = new WorkerView();
    }

    public void findAllWorker() {
        workerView.printAllWorker(workerService.findAllWorker());
    }
}
