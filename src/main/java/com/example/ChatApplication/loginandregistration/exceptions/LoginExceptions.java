package com.example.ChatApplication.loginandregistration.exceptions;

public class LoginExceptions extends Exception{

    public LoginExceptions() {
        super();
    }

    public LoginExceptions(String message) {
        super(message);
    }

    public LoginExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginExceptions(Throwable cause) {
        super(cause);
    }

    protected LoginExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
