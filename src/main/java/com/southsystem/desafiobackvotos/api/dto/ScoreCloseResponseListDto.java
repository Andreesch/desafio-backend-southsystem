package com.southsystem.desafiobackvotos.api.dto;

import java.util.List;

public class ScoreCloseResponseListDto {

    private List<ScoreCloseResponseDto> items;

    public List<ScoreCloseResponseDto> getItems() {
        return items;
    }

    public ScoreCloseResponseListDto setItems(List<ScoreCloseResponseDto> items) {
        this.items = items;
        return this;
    }
}
