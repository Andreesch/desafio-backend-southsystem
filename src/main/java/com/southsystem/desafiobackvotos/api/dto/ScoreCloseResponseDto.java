package com.southsystem.desafiobackvotos.api.dto;

import java.time.LocalDateTime;

public class ScoreCloseResponseDto {

    private String scoreName;

    private String scoreSubject;

    private LocalDateTime closeAt;

    private Long agreedResult;

    private Long denyResult;

    private boolean isApproved;

    public String getScoreName() {
        return scoreName;
    }

    public ScoreCloseResponseDto setScoreName(String scoreName) {
        this.scoreName = scoreName;
        return this;
    }

    public String getScoreSubject() {
        return scoreSubject;
    }

    public ScoreCloseResponseDto setScoreSubject(String scoreSubject) {
        this.scoreSubject = scoreSubject;
        return this;
    }

    public LocalDateTime getCloseAt() {
        return closeAt;
    }

    public ScoreCloseResponseDto setCloseAt(LocalDateTime closeAt) {
        this.closeAt = closeAt;
        return this;
    }

    public Long getAgreedResult() {
        return agreedResult;
    }

    public ScoreCloseResponseDto setAgreedResult(Long agreedResult) {
        this.agreedResult = agreedResult;
        return this;
    }

    public Long getDenyResult() {
        return denyResult;
    }

    public ScoreCloseResponseDto setDenyResult(Long denyResult) {
        this.denyResult = denyResult;
        return this;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public ScoreCloseResponseDto setApproved(boolean approved) {
        isApproved = approved;
        return this;
    }
}
