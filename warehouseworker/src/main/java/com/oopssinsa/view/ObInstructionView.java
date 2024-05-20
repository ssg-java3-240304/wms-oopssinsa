package com.oopssinsa.view;

import com.oopssinsa.model.dto.ObInstructionDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

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
    public String inputUpdateObInstructionStatus(String[] obInfo){
        Scanner scanner = new Scanner(System.in);
        System.out.print("출고ID 입력: ");
        obInfo[0] = scanner.nextLine();
        System.out.print("상품ID 입력: ");
        obInfo[1] = scanner.nextLine();
        System.out.print("제조일자 입력: ");
        obInfo[2] = scanner.nextLine();
        System.out.print("완료 상태 입력: ");
        String updateStatus = scanner.nextLine();
        return updateStatus;
    }
}
