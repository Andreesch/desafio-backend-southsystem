package com.southsystem.desafiobackvotos.api.exception;

import com.southsystem.desafiobackvotos.api.exception.generic.ForbiddenException;
import com.southsystem.desafiobackvotos.config.Translator;

public class ScoreVoteAlreadyExistsException extends ForbiddenException {

    public ScoreVoteAlreadyExistsException(String federalIdentification) {
        super(Translator.toLocale("scoreVote.alreadyExists", federalIdentification));
    }
}
