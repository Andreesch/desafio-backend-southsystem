package com.southsystem.desafiobackvotos.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("OpenScore")
public class ScoreOpenDto {

    @ApiModelProperty(value = "${score.open.id}")
    private String scoreId;

    @ApiModelProperty(value = "${score.open.durationInMinutes}")
    private Long durationInMinutes;

    public String getScoreId() {
        return scoreId;
    }

    public ScoreOpenDto setScoreId(String scoreId) {
        this.scoreId = scoreId;
        return this;
    }

    public Long getDurationInMinutes() {
        return durationInMinutes;
    }

    public ScoreOpenDto setDurationInMinutes(Long durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
        return this;
    }
}
