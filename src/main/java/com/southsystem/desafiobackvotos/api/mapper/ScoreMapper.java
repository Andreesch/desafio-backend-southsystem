package com.southsystem.desafiobackvotos.api.mapper;

import org.modelmapper.ModelMapper;

import com.southsystem.desafiobackvotos.api.dto.ScoreCreateDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreResponseDto;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreStatus;

public class ScoreMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static Score toEntity(ScoreCreateDto scoreCreateDto) {
        return modelMapper.map(scoreCreateDto, Score.class)
                .setScoreStatus(ScoreStatus.OPEN);
    }

    public static ScoreResponseDto toResponseDto(Score score) {
        return modelMapper.map(score, ScoreResponseDto.class);
    }
}
