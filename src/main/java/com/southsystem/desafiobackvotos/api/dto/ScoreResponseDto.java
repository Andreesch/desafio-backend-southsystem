package com.southsystem.desafiobackvotos.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ScoreResponse")
public class ScoreResponseDto {

    @ApiModelProperty(value = "${score.id}")
    private String id;

    @ApiModelProperty(value = "${score.name}")
    private String name;

    @ApiModelProperty(value = "${score.subject}")
    private String subject;

    public String getId() {
        return id;
    }

    public ScoreResponseDto setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ScoreResponseDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ScoreResponseDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
