package com.oopssinsa.view;

import com.oopssinsa.model.constants.Error;

public class ErrorView {
    public void printError(Error error) {
        System.err.println(error.getMsg());
    }
}
