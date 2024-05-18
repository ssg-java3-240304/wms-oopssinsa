package com.oopssinsa.controller;

import com.oopssinsa.model.service.LoginService;
import com.oopssinsa.view.LoginView;

public class LoginController {
    LoginView loginView = new LoginView();
    LoginService loginService = new LoginService();
    public String loginValidation(){
        String id=null;
        String password=null;
        loginView.inputLogin(id, password);
        if(id!=null&&password!=null){
            boolean result = loginService.loginValidation(id, password);
            loginView.displayLoginResult(result, id);
            return id;
        }
        else{
            loginView.displayInputError();
            return null;
        }
    }
}
