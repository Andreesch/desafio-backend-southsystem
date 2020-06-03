package com.southsystem.desafiobackvotos.config;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.southsystem.desafiobackvotos.api.exception.generic.ForbiddenException;
import com.southsystem.desafiobackvotos.api.exception.generic.NotFoundException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public void handleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(NotFoundException.STATUS_CODE);
    }

    @ExceptionHandler(ForbiddenException.class)
    public void handleForbidden(HttpServletResponse response) throws IOException {
        response.sendError(ForbiddenException.STATUS_CODE);
    }
}

