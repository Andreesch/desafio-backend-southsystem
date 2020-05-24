package com.southsystem.desafiobackvotos.api.dto;

import java.time.LocalDateTime;

public class ScoreOpenResponseDto {

    private String scoreId;

    private LocalDateTime openAt;

    private LocalDateTime closeAt;

    public String getScoreId() {
        return scoreId;
    }

    public ScoreOpenResponseDto setScoreId(String scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    public LocalDateTime getOpenAt() {
        return openAt;
    }

    public ScoreOpenResponseDto setOpenAt(LocalDateTime openAt) {
        this.openAt = openAt;
        return this;
    }

    public LocalDateTime getCloseAt() {
        return closeAt;
    }

    public ScoreOpenResponseDto setCloseAt(LocalDateTime closeAt) {
        this.closeAt = closeAt;
        return this;
    }
}
