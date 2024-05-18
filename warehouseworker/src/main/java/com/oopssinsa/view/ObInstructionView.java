package com.oopssinsa.view;

import com.oopssinsa.model.dto.ObInstructionDto;

import java.util.List;

public class ObInstructionView {
    public static void displayObInstructions(List<ObInstructionDto> obInstructions) {
        System.out.println("-----------------------------------------------------------");
        for(ObInstructionDto obInstructionDto : obInstructions){
            System.out.println("출고ID: "+obInstructionDto.getId() + " 상품ID: "+obInstructionDto.getProductId()+
                    " 제조일자ID: "+ obInstructionDto.getManufactureId() + " 위치: "+ obInstructionDto.getLocationId()+
                    " 작업자ID: "+obInstructionDto.getWorkerId()
                    );
        }
    }
}
