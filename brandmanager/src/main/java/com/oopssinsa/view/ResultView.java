package com.oopssinsa.view;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.dto.IbDetailDto;

import java.util.List;

public class ResultView {
    public static void displayInsertProductResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayIbRequestResult(String type, int result) {
        System.out.println("> 📢📢📢 " + type + " " + (result > 0 ? "성공!" : "실패!") + "📢📢📢");
    }

    public static void displayMenu(AccountDto accountDto) {
        if(accountDto == null) {
            System.out.println("등록되지 않은 사용자 입니다.");
        } else {
            System.out.println(accountDto.getName() + "님 로그인 완료. 환영합니다!!!");
        }

    }

    public static void displayIbDetailList(List<IbDetailDto> list) {
        if (list.isEmpty()) {
            System.out.println("> 😅😅😅 조회된 입고 요청이 없습니다. 😅😅😅");
        } else {
            System.out.println("--------------------------------------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n", "id", "manufacture_id", "product_id", "login_id", "quantity", "ib_date", "completion_date", "status");
            System.out.println("--------------------------------------------------------------------------");
            for(IbDetailDto ibDetailDto : list) {
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%s\t%s\t%s\n",
                        ibDetailDto.getId(),
                        ibDetailDto.getManufactureId(),
                        ibDetailDto.getProductId(),
                        ibDetailDto.getLoginId(),
                        ibDetailDto.getQuantity(),
                        ibDetailDto.getIbDate(),
                        ibDetailDto.getCompletionDate(),
                        ibDetailDto.getStatus()
                );
            }
            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
