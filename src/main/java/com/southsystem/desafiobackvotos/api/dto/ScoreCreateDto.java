package com.southsystem.desafiobackvotos.api.dto;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("ScoreCreate")
public class ScoreCreateDto {

    @NotBlank
    @ApiModelProperty(value = "${score.name}")
    private String name;

    @NotBlank
    @ApiModelProperty(value = "${score.subject}")
    private String subject;

    public String getName() {
        return name;
    }

    public ScoreCreateDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSubject() {
        return subject;
    }

    public ScoreCreateDto setSubject(String subject) {
        this.subject = subject;
        return this;
    }
}
