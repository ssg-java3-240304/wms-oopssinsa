package com.oopssinsa.view;

import com.oopssinsa.model.dto.IbInstructionDto;
import com.oopssinsa.model.service.IbService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class IbInstructionView {
    IbService ibService = new IbService();
    public void displayIbInstructions(List<IbInstructionDto> ibInstructions) {
        System.out.println("---------------------------------------------------------------------------");
        for(IbInstructionDto ibInstructionDto : ibInstructions){
            System.out.println("입고ID: "+ ibInstructionDto.getIbId()+ " 상품ID: "+ ibInstructionDto.getProductId()+
                    " 제조일자ID: "+ ibInstructionDto.getManufactureId() + " 위치: "+ ibService.findProductLocation(ibInstructionDto.getProductId())
                    + " 작업자ID: "+ ibInstructionDto.getWorkerId()
            );
            // + "위치: "+ ibInstructionDto.getLocationId()
        }
        System.out.println("---------------------------------------------------------------------------");
    }
    public String inputUpdateIbInstructionStatus(String[] ibInfo){
//
//        IbService ibService = new IbService();

        Scanner scanner = new Scanner(System.in);
        System.out.print("입고ID 입력: ");
        ibInfo[0] = scanner.nextLine();
        System.out.println("상품ID 입력: ");
        ibInfo[1] = scanner.nextLine();
//        scanner.nextLine();
        System.out.println("제조일자 입력: ");
        ibInfo[2] = scanner.nextLine();

        long locationId = ibService.findProductLocation(ibInfo[1]);
        System.out.println("해당 상품을 " + locationId + "번 위치에 적치시킵니다.");

        System.out.println("완료 상태 입력 (S / F): ");
        String updateStatus = scanner.nextLine();
//        return updateStatus.charAt(0);
        return updateStatus;
    }
}
