package com.mohamed.fullstack.exception;

public class ApiRequestExcetion extends RuntimeException{
    public ApiRequestExcetion(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestExcetion(String message) {
        super(message);
    }
}
