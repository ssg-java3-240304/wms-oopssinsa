package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbInstructionDto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IbInstructionView {
    public void displayIbInstructions(List<IbInstructionDto> ibInstructions) {
        System.out.println("-----------------------------------------------------------");
        for(IbInstructionDto ibInstructionDto : ibInstructions){
            System.out.println("입고ID: "+ ibInstructionDto.getIbId()+ " 상품ID: "+ ibInstructionDto.getProductId()+
                    " 제조일자ID: "+ ibInstructionDto.getManufactureID() + "위치: "+ ibInstructionDto.getLocationId()+
                    "작업자ID: "+ ibInstructionDto.getWorkerId()
            );

        }
        System.out.println("-----------------------------------------------------------");
    }
    public String inputUpdateIbInstructionStatus(long IbInstructionId, String productId, LocalDate manufactureId){
        Scanner scanner = new Scanner(System.in);
        System.out.print("입고ID 입력: ");
        IbInstructionId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("상품ID 입력: ");
        productId = scanner.nextLine();
        scanner.nextLine();
        System.out.println("제조일자 입력: ");
        manufactureId = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("완료 상태 입력: ");
        String updateStatus = scanner.nextLine();
        return updateStatus;
    }
}
