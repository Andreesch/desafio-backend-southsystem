package com.southsystem.desafiobackvotos.api.mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.southsystem.desafiobackvotos.api.dto.ScoreCloseResponseDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreCloseResponseListDto;
import com.southsystem.desafiobackvotos.api.helper.ScoreCloseHelper;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreClose;
import com.southsystem.desafiobackvotos.service.vo.ScoreCloseMessageVO;

public class ScoreCloseMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static ScoreClose toEntity(Score referenceScore) {
        Long approvedVotes = ScoreCloseHelper.getApprovedVotes(referenceScore.getScoreVotes());
        Long denyVotes = ScoreCloseHelper.getDenyVotes(referenceScore.getScoreVotes());

        return new ScoreClose()
                .setCloseAt(LocalDateTime.now())
                .setScore(referenceScore)
                .setAgreedResult(approvedVotes)
                .setDenyResult(denyVotes)
                .setScoreCloseStatus(ScoreCloseHelper.buildStatusByVotes(approvedVotes, denyVotes));
    }

    public static ScoreCloseMessageVO toMessageVO(ScoreClose scoreClose) {
        return modelMapper.map(scoreClose, ScoreCloseMessageVO.class)
                .setApproved(ScoreCloseHelper.isApproved(scoreClose.getAgreedResult(), scoreClose.getDenyResult()));
    }

    public static ScoreCloseResponseDto toResponseDto(ScoreClose scoreClose) {
        return modelMapper.map(scoreClose, ScoreCloseResponseDto.class)
                .setScoreName(scoreClose.getScore().getName())
                .setScoreSubject(scoreClose.getScore().getSubject())
                .setApproved(ScoreCloseHelper.isApproved(scoreClose.getAgreedResult(), scoreClose.getDenyResult()));
    }

    public static ScoreCloseResponseListDto toResponseListDto(List<ScoreClose> scoreCloseList) {
        return new ScoreCloseResponseListDto()
                .setItems(scoreCloseList.stream()
                        .map(ScoreCloseMapper::toResponseDto)
                        .collect(Collectors.toList()));
    }
}
