package com.oopssinsa.controller;

import com.oopssinsa.model.dto.AccountDto;
import com.oopssinsa.model.service.AccountService;
import com.oopssinsa.view.AccountView;

public class AccountController {

    private final AccountService accountService;
    private final AccountView accountView;


    public AccountController() {
        this.accountService = new AccountService();
        this.accountView = new AccountView();
    }

    public boolean logIn() {
        accountView.printStart();

        while (true) {
            String id = accountView.getId();
            if (id.equals("q!")) {
                return false;
            }

            String password = accountView.getPassword();
            AccountDto account = accountService.findAccountById(id);
            if (account == null) {
                accountView.printNonexistentAccount();
                continue;
            }
            if (!account.getPassword().equals(password)) {
                accountView.printWrongPassword();
                continue;
            }
            if (!account.getRole().equals("WM")) {
                accountView.printWrongRight();
                continue;
            }

            break;
        }

        return true;
    }
}
