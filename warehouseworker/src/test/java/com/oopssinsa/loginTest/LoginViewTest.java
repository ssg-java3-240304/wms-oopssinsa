package com.oopssinsa.loginTest;

import java.util.Scanner;

public class LoginViewTest {
    public void inputLogin(String id, String password){
        Scanner scanner = new Scanner(System.in);
        System.out.print("창고 작업자 아이디를 입력해주세요: ");
        id = "test";
        System.out.print("창고 작업자 비밀번호를 입력해주세요: ");
        password = "test";
    }

    public void displayLoginResult(boolean result, String id){
        if(result){
            System.out.println(id+ "님 로그인 완료. 환영합니다.");
        }
        else{
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
        }
    }
    public void displayInputError(){
        System.out.println("입력 값이 잘못되었습니다.");
    }
}
