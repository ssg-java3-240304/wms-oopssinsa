package com.oopssinsa.view;

public class AccountView {
    private final InputView inputView;

    public AccountView() {
        this.inputView = new InputView();
    }

    public String getId() {
        System.out.println("아이디를 입력하세요. (종료 q!)");
        return inputView.getId();
    }

    public String getPassword() {
        System.out.println("비밀번호를 입력하세요.");
        return inputView.getPassword();
    }

    public void printNonexistentAccount() {
        System.out.println("아이디가 존재하지 않습니다.");
    }

    public void printWrongPassword() {
        System.out.println("비밀번호가 틀립니다.");
    }
    public void printWrongRight() {
        System.out.println("해당 권한이 업습니다.");
    }

    public void printStart() {
        System.out.println("Warehouse Manager");
    }
}
