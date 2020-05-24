package com.southsystem.desafiobackvotos.api.exception;

import com.southsystem.desafiobackvotos.api.exception.generic.ForbiddenException;
import com.southsystem.desafiobackvotos.config.Translator;

public class ScoreVoteUnableToVoteException extends ForbiddenException {

    public ScoreVoteUnableToVoteException(String federalIdentification) {
        super(Translator.toLocale("scoreVote.unableToVote", federalIdentification));
    }
}
