package com.oopssinsa.controller;

import com.oopssinsa.model.service.ObService;
import com.oopssinsa.view.IbView;
import com.oopssinsa.view.InputView;
import com.oopssinsa.view.ObView;

public class ObController {

    private final ObService obService;
    private final ObView obView;
    private final InputView inputView;

    public ObController() {
        this.obService = new ObService();
        this.obView = new ObView();
        this.inputView = new InputView();
    }

    public void findObByRequestState(){
        obView.printObRequestState(obService.findObByRequestState());
    }

    public void findAllOb() {
        obView.printAllOb(obService.findAllOb());
    }

}
