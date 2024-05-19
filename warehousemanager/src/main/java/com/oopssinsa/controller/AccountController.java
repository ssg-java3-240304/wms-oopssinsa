package com.oopssinsa.controller;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.service.AccountService;
import com.oopssinsa.view.InputView;

public class AccountController {
    private final AccountService accountService;
    private final InputView inputView;


    public AccountController() {
        this.accountService = new AccountService();
        this.inputView = new InputView();
    }

    public boolean logIn() {
        System.out.println("Warehouse Manager");

        while (true) {
            System.out.println("아이디를 입력하세요. (종료 q!)");
            String id = inputView.getId();
            if (id.equals("q!")) {
                return false;
            }
            System.out.println("비밀번호를 입력하세요.");
            String password = inputView.getPassword();
            AccountDto account = accountService.findAccountById(id);
            if (!account.getPassword().equals(password)) {
                System.out.println("비밀번호가 틀립니다.");
                continue;
            }
            if (!account.getRole().equals("WM")) {
                System.out.println("해당 권한이 업습니다.");
                continue;
            }

            break;
        }

        return true;
    }
}
