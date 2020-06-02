package com.southsystem.desafiobackvotos.api.dto;

import java.time.LocalDateTime;

public class ScoreOpenResponseDto {

    private String id;

    private LocalDateTime openAt;

    private LocalDateTime closeAt;

    public String getId() {
        return id;
    }

    public ScoreOpenResponseDto setId(String id) {
        this.id = id;
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
