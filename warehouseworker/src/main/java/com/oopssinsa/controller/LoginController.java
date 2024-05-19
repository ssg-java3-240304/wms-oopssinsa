package com.oopssinsa.controller;

import com.oopssinsa.model.dto.LoginDto;
import com.oopssinsa.model.service.LoginService;
import com.oopssinsa.view.LoginView;

import java.util.Scanner;

public class LoginController {
    LoginView loginView = new LoginView();
    LoginService loginService = new LoginService();
    public String loginValidation(){
        String[] loginInfo = new String[2]; // index0: 아이디, index1: 비밀번호
        loginView.inputLogin(loginInfo);
        String id = loginInfo[0];
        String password = loginInfo[1];
        boolean result = loginService.loginValidation(id, password);
        loginView.displayLoginResult(result, id);
        if(result){
            return id;
        }
        else return null;

    }

    public boolean loginValidation(String id, String password){
        if(id!=null&&password!=null){
            return loginService.loginValidation(id, password);
        }
        else{
            return false;
        }
    }

    //예작시
//    public boolean loginValidation(String id, String password){
//        if(id!=null&&password!=null){
//            return loginService.loginValidation(id, password);
//        }
//        else{
//            return false;
//        }
//    }
}
