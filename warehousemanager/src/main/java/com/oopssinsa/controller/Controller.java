package com.oopssinsa.controller;

import com.oopssinsa.view.InputView;

public class Controller {
    private final IbController ibController;
    private final ObController obController;
    private final InputView inputView;

    public Controller() {
        this.ibController = new IbController();
        this.obController = new ObController();
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
                case 5:
                    obController.findAllOb();
                    break;
                case 6:
                    obController.findObByRequestState();
                    break;
                case 7:
                    obController.updateState();
                    break;
                case 8:
                    obController.insertObWorker();
                    break;
                case 9:
                    return;
            }
        }
    }

}
