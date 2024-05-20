package com.oopssinsa.view;

import com.oopssinsa.model.dto.AccountDto;

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
}
