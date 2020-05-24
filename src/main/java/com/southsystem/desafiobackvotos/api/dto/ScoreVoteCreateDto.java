package com.southsystem.desafiobackvotos.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ScoreVoteCreateDto {

    @NotBlank
    private String scoreId;

    @NotBlank
    private String federalIdentification;

    @NotNull
    private Boolean agreed;

    public String getScoreId() {
        return scoreId;
    }

    public ScoreVoteCreateDto setScoreId(String scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public ScoreVoteCreateDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public ScoreVoteCreateDto setAgreed(Boolean agreed) {
        this.agreed = agreed;
        return this;
    }
}
