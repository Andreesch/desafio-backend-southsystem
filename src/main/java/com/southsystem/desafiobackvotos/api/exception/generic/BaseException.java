package com.southsystem.desafiobackvotos.api.exception.generic;

public abstract class BaseException extends RuntimeException {
    private int statusCode;

    public BaseException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}

