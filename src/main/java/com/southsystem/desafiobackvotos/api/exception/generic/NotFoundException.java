package com.southsystem.desafiobackvotos.api.exception.generic;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public static final int STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public NotFoundException(String message) {
        super(message, STATUS_CODE);
    }
}
