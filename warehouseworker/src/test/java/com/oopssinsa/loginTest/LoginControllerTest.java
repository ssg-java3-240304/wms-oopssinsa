package com.oopssinsa.loginTest;

public class LoginControllerTest {
    LoginViewTest loginViewTest = new LoginViewTest();
    LoginServiceTest loginServiceTest = new LoginServiceTest();
    public String loginValidation(){
        String id=null;
        String password=null;
        loginViewTest.inputLogin(id, password);
        if(id!=null&&password!=null){
            boolean result = loginServiceTest.loginValidation(id, password);
            loginViewTest.displayLoginResult(result, id);
            return id;
        }
        else{
            loginViewTest.displayInputError();
            return "";
        }
    }
}
