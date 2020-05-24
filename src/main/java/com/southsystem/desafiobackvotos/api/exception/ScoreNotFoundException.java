package com.southsystem.desafiobackvotos.api.exception;

import com.southsystem.desafiobackvotos.api.exception.generic.NotFoundException;
import com.southsystem.desafiobackvotos.config.Translator;

public class ScoreNotFoundException extends NotFoundException {

    public ScoreNotFoundException(String id) {
        super(Translator.toLocale("score.notFound", id));
    }
}
