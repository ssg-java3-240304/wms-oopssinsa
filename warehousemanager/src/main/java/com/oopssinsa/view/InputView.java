package com.oopssinsa.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public int getWork() {
        System.out.println("작업할 번호를 입력해주세요.");
        System.out.println("입고");
        System.out.println("1. 전체 입고 처리 내역 조회");
        System.out.println("2. 입고 요청 상태인 입고 조회 ");
        System.out.println("3. 입고 요청 상태 변경");
        System.out.println("4. 입고 작업 배정");
        System.out.println();
        System.out.println("출고");
        System.out.println("5. 전체 출고 처리내역 조회");
        System.out.println("6. 출고 요청 상태인 출고 조회");
        System.out.println("7. 출고 요청 상태 변경");
        System.out.println("8. 출고 작업 배정");
        System.out.println();
        System.out.println("작업자");
        System.out.println("9. 작업자 목록 조회");
        System.out.println("10. 종료");
        return sc.nextInt();
    }

    public String getId() {
        return sc.next();
    }

    public String getPassword() {
        return sc.next();
    }

    public int getNumber() {
        return sc.nextInt();
    }

    public String getYesOrNo() {
        System.out.println("요청-> 대기(y) or 반려(n) ");
        return sc.next();
    }
}
