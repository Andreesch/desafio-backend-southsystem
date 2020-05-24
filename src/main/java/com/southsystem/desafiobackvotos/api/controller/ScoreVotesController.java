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

import com.southsystem.desafiobackvotos.api.dto.ScoreResponseDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreVoteCreateDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreVoteResponseDto;
import com.southsystem.desafiobackvotos.api.mapper.ScoreVoteMapper;
import com.southsystem.desafiobackvotos.service.ScoreVoteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("ScoreVotesController")
@RequestMapping(RestPath.BASE_PATH + "/score-votes")
@Api(tags = "Score Votes")
public class ScoreVotesController {

    @Autowired
    private ScoreVoteService scoreVoteService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "${v1.scoreVote.create}")
    @ApiResponses({
            @ApiResponse(code = 201, message = ApiResponseMessages.MESSAGE_201, response = ScoreResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)

    })
    public ScoreVoteResponseDto create(
            @ApiParam(value = "${v1.scoreVote}", required = true) @RequestBody @Valid ScoreVoteCreateDto scoreVoteCreateDto) {
        return ScoreVoteMapper.toResponseDto(scoreVoteService.create(scoreVoteCreateDto));
    }
}
