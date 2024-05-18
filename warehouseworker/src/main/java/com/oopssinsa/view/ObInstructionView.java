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
    public String inputUpdateObInstructionStatus(long ObInstructionId, long productId, LocalDate manufactureId){
        Scanner scanner = new Scanner(System.in);
        System.out.print("출고ID 입력: ");
        ObInstructionId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("상품ID 입력: ");
        productId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("제조일자 입력: ");
        manufactureId = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("완료 상태 입력: ");
        String updateStatus = scanner.nextLine();
        return updateStatus;
    }
}
