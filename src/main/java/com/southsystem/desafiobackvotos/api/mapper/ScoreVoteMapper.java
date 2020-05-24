package com.southsystem.desafiobackvotos.api.mapper;

import org.modelmapper.ModelMapper;

import com.southsystem.desafiobackvotos.api.dto.ScoreVoteResponseDto;
import com.southsystem.desafiobackvotos.entity.ScoreVote;

public class ScoreVoteMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ScoreVoteResponseDto toResponseDto(ScoreVote scoreVote) {
        return modelMapper.map(scoreVote, ScoreVoteResponseDto.class)
                .setFederalIdentification(scoreVote.getAssociate().getFederalIdentification())
                .setScoreId(scoreVote.getScore().getId());
    }
}
