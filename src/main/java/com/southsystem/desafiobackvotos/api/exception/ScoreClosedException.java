package com.southsystem.desafiobackvotos.api.exception;

import com.southsystem.desafiobackvotos.api.exception.generic.ForbiddenException;
import com.southsystem.desafiobackvotos.config.Translator;

public class ScoreClosedException extends ForbiddenException {

    public ScoreClosedException(String id) {
        super(Translator.toLocale("score.closed", id));
    }
}
