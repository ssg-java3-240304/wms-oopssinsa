package com.oopssinsa.loginTest;

public class LoginServiceTest {
    public boolean loginValidation(String id, String password) {
        if(id.equals("test")&&password.equals("test"))return true;
        else return false;
    }
}
