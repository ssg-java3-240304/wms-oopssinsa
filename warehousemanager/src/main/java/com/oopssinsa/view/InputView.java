package com.oopssinsa.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public int getWork() {
        System.out.println("작업할 번호를 입력해주세요.");
        System.out.println("1. 전체 입고 처리 내역 조회");
        System.out.println("2. 입고 요청 상태인 입고 조회");
        return sc.nextInt();
    }

}
