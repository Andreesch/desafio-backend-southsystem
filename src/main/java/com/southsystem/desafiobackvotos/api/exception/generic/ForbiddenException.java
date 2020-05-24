package com.southsystem.desafiobackvotos.api.exception.generic;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends BaseException {
    public static final int STATUS_CODE = HttpStatus.FORBIDDEN.value();

    public ForbiddenException(String message) {
        super(message, STATUS_CODE);
    }
}
