package com.oopssinsa.controller;

import com.oopssinsa.model.dto.ObInstructionDto;
import com.oopssinsa.model.service.ObService;
import com.oopssinsa.view.ObInstructionView;

import java.util.List;

public class ObController {
    private String workerId=null;
    ObService obService = new ObService();
    ObInstructionView obView = new ObInstructionView();

    public void setWorkerId(String id){
        this.workerId = id;
    }
    public void getObInstructionToDo() {
        List<ObInstructionDto> obInstructions = obService.getObInstructionToDo(this.workerId);
        if(obInstructions!=null){
            ObInstructionView.displayObInstructions(obInstructions);
        }
        else{
            System.out.println("출고 지시 목록 오류 발생");
        }
    }
}
