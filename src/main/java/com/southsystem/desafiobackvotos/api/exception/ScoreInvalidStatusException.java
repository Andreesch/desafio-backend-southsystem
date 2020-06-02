package com.southsystem.desafiobackvotos.api.exception;

import com.southsystem.desafiobackvotos.api.exception.generic.ForbiddenException;
import com.southsystem.desafiobackvotos.config.Translator;

public class ScoreInvalidStatusException extends ForbiddenException {

    public ScoreInvalidStatusException(String id) {
        super(Translator.toLocale("score.open.invalidStatus", id));
    }
}
