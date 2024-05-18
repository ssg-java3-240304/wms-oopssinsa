package com.oopssinsa.controller;

import com.oopssinsa.view.InputView;

public class Controller {
    private final IbController ibController;
    private final InputView inputView;

    public Controller() {
        this.ibController = new IbController();
        this.inputView = new InputView();
    }

    public void run() {
        workWarehouseManager();
    }

    public void workWarehouseManager() {
        while (true) {
            switch (inputView.getWork()) {
                case 1:
                    ibController.findAllIb();
                    break;
                case 2:
                    ibController.findIbByRequestState();
                    break;
                case 3:
                    ibController.updateState();
                    break;
                case 4:
                    ibController.insertIbWorker();
                    break;
                case 7:
                    return;
            }
        }
    }

}
