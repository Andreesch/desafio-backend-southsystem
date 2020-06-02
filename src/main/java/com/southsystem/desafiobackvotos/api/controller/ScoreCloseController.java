package com.southsystem.desafiobackvotos.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.southsystem.desafiobackvotos.api.dto.ScoreCloseResponseDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreCloseResponseListDto;
import com.southsystem.desafiobackvotos.api.mapper.ScoreCloseMapper;
import com.southsystem.desafiobackvotos.service.ScoreCloseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("ScoreCloseController")
@RequestMapping(RestPath.BASE_PATH + "/scores-close")
@Api(tags = "ScoreClosed")
public class ScoreCloseController {

    @Autowired
    private ScoreCloseService scoreCloseService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/find-by-score/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "${v1.scoreClose.findByScore}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_200, response = ScoreCloseResponseDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)
    })
    public ScoreCloseResponseDto findByScore(@ApiParam("${v1.scoreClose.score.id}") @PathVariable("id") String id) {
        return ScoreCloseMapper.toResponseDto(scoreCloseService.findByScore(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/find-all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "${v1.scoreClose.findAll}")
    @ApiResponses({
            @ApiResponse(code = 200, message = ApiResponseMessages.MESSAGE_200, response = ScoreCloseResponseListDto.class),
            @ApiResponse(code = 403, message = ApiResponseMessages.MESSAGE_403),
            @ApiResponse(code = 404, message = ApiResponseMessages.MESSAGE_404)
    })
    public ScoreCloseResponseListDto findAll() {
        return ScoreCloseMapper.toResponseListDto(scoreCloseService.findAll());
    }

}
