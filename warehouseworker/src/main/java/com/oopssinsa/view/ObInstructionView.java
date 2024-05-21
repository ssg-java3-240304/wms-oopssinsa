package com.oopssinsa.view;

import com.oopssinsa.model.dto.ObInstructionDto;
import com.oopssinsa.model.service.ObService;

import java.util.List;
import java.util.Scanner;

public class ObInstructionView {
    ObService obService = new ObService();
    public void displayObInstructions(List<ObInstructionDto> obInstructions) {
        System.out.println("-----------------------------------------------------------");
        for(ObInstructionDto obInstructionDto : obInstructions){
            System.out.println("출고ID: "+obInstructionDto.getId() + " 상품ID: "+obInstructionDto.getProductId()+
                    " 제조일자ID: " + obInstructionDto.getManufactureId() + " 위치: " + obService.findProductLocation(obInstructionDto.getProductId()) +
                    " 작업자ID: "+obInstructionDto.getWorkerId()
                    );
            //  + " 위치: "+ obInstructionDto.getLocationId()
        }
    }
    public String inputUpdateObInstructionStatus(String[] obInfo){
        ObService obService = new ObService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("출고ID 입력: ");
        obInfo[0] = scanner.nextLine();
        System.out.print("상품ID 입력: ");
        obInfo[1] = scanner.nextLine();
        System.out.print("제조일자 입력: ");
        obInfo[2] = scanner.nextLine();

        long locationId = obService.findProductLocation(obInfo[1]);
        System.out.println("해당 상품은 " + locationId + "번 위치에 있습니다.");

        System.out.print("완료 상태 입력: ");
        String updateStatus = scanner.nextLine();
        return updateStatus;
    }
}
