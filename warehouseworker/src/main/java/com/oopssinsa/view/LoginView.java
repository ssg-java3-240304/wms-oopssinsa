package com.oopssinsa.view;

import com.oopssinsa.controller.LoginController;

import java.util.Scanner;

public class LoginView {
    public void inputLogin(String[] loginInfo){
        System.out.println("==================================LOGIN==================================");
        Scanner scanner = new Scanner(System.in);
        System.out.print("창고 작업자 아이디를 입력해주세요: ");
        loginInfo[0] = scanner.nextLine();
        System.out.print("창고 작업자 비밀번호를 입력해주세요: ");
        loginInfo[1] = scanner.nextLine();
    }
    public void displayLoginResult(boolean result, String id){
        if(result){
            System.out.println(id+ "님 로그인 완료. 환영합니다.");
        }
        else{
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
            System.out.println("===========================================================================");
        }
    }

    // 예작시
//    public String inputLogin(){
//        LoginController loginController = new LoginController();
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("창고 작업자 아이디를 입력해주세요: ");
//        String id = scanner.nextLine();
//        System.out.print("창고 작업자 비밀번호를 입력해주세요: ");
//        String password = scanner.nextLine();
//
//        if (id == null || password == null) {
//            displayInputError();
//        }
//
//        if (loginController.loginValidation(id, password)) {
//            displayLoginResult(id);
//            return id;
//        } else {
//            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
//            return null;
//        }
//    }

    public void displayLoginResult(String id){
        System.out.println(id+ "님 로그인 완료. 환영합니다.");
    }
    public void displayInputError(){
        System.out.println("입력 값이 잘못되었습니다.");
    }
}
