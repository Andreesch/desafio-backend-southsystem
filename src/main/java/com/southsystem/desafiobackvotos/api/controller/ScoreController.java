package com.southsystem.desafiobackvotos.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.desafiobackvotos.api.dto.ScoreCreateDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreResponseDto;
import com.southsystem.desafiobackvotos.api.mapper.ScoreMapper;
import com.southsystem.desafiobackvotos.service.ScoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("ScoreController")
@RequestMapping(RestPath.BASE_PATH + "/scores")
@Api(tags = "Scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.score.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201, response = ScoreResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ScoreResponseDto create(
            @ApiParam(value = "${v1.score}", required = true) @RequestBody @Valid ScoreCreateDto scoreCreateDto) {
        return ScoreMapper.toResponseDto(scoreService.create(scoreCreateDto));
    }
}
