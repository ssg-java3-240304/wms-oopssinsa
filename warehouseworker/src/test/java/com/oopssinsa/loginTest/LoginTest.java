package com.oopssinsa.loginTest;

import com.oopssinsa.controller.LoginController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class LoginTest {
    @Test
    public void loginTest(){
        LoginControllerTest loginControllerTest = new LoginControllerTest();
        String workerIdTest = "";
        while(!workerIdTest.equals("")){
            workerIdTest= loginControllerTest.loginValidation();
        }
        System.out.println("로그인성공");
    }

    @Test
    public void stringNullTest(){
        String str = "";
        setStr(str);
        Assertions.assertThat(str.equals("AA"));
    }
    public void setStr(String str){
        str="AA";
    }
}
