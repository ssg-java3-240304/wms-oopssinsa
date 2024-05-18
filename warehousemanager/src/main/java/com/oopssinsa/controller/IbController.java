package com.oopssinsa.controller;

import com.oopssinsa.model.service.IbService;
import com.oopssinsa.view.IbView;

public class IbController {

    private final IbService ibService ;
    private final IbView ibView;

    public IbController() {
        this.ibService = new IbService();
        this.ibView = new IbView();
    }

    public void findAllIb() {
        ibView.printAllIb(ibService.findAllIb());
    }

    public void findIbByRequestState() {
        ibView.printRequestIb(ibService.findIbByRequestState());
    }

}
