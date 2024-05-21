package com.oopssinsa.controller;

import com.oopssinsa.view.InputView;

public class Controller {
    private final IbController ibController;
    private final ObController obController;
    private final WorkerController workerController;
    private final AccountController accountController;
    private final InputView inputView;

    public Controller() {
        this.ibController = new IbController();
        this.obController = new ObController();
        this.workerController = new WorkerController();
        this.accountController = new AccountController();
        this.inputView = new InputView();
    }

    public void run() {
        if (!accountController.logIn()) {
            return;
        }
        workWarehouseManager();
    }

    public void workWarehouseManager() {
        while (true) {
            switch (inputView.getWork()) {
                case 1:
                    ibController.findAllIb(); // 전체 입고 처리 내역 조회
                    break;
                case 2:
                    ibController.findIbByRequestState(); // 입고 요청 상태인 입고 조회
                    break;
                case 3:
                    ibController.updateState(); // 입고 요청 상태 변경
                    break;
                case 4:
                    ibController.insertIbWorker(); // 입고 작업 배정
                    break;
                case 5:
                    obController.findAllOb(); // 전체 출고 처리내역 조회
                    break;
                case 6:
                    obController.findObByRequestState(); // 출고 요청 상태인 출고 조회
                    break;
                case 7:
                    obController.updateState(); // 출고 요청 상태 변경
                    break;
                case 8:
                    obController.insertObWorker(); // 출고 작업 배정
                    break;
                case 9:
                    workerController.findAllWorker(); // 작업자 목록 조회
                    break;
                case 10:
                    return;
            }
        }
    }
}
