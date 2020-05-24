package com.southsystem.desafiobackvotos.api.dto;

import java.time.LocalDateTime;

public class ScoreVoteResponseDto {

    private String id;

    private String scoreId;

    private String federalIdentification;

    private Boolean agreed;

    private LocalDateTime voteAt;

    public String getId() {
        return id;
    }

    public ScoreVoteResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getScoreId() {
        return scoreId;
    }

    public ScoreVoteResponseDto setScoreId(String scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    public String getFederalIdentification() {
        return federalIdentification;
    }

    public ScoreVoteResponseDto setFederalIdentification(String federalIdentification) {
        this.federalIdentification = federalIdentification;
        return this;
    }

    public Boolean getAgreed() {
        return agreed;
    }

    public ScoreVoteResponseDto setAgreed(Boolean agreed) {
        this.agreed = agreed;
        return this;
    }

    public LocalDateTime getVoteAt() {
        return voteAt;
    }

    public ScoreVoteResponseDto setVoteAt(LocalDateTime voteAt) {
        this.voteAt = voteAt;
        return this;
    }
}
