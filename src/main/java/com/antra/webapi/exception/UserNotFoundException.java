package com.antra.webapi.exception;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {
    private String errorMsg;

    public UserNotFoundException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
