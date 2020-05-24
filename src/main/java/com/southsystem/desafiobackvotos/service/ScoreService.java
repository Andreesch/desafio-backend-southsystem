package com.southsystem.desafiobackvotos.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.desafiobackvotos.api.dto.ScoreOpenDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreCreateDto;
import com.southsystem.desafiobackvotos.api.exception.ScoreNotFoundException;
import com.southsystem.desafiobackvotos.api.mapper.ScoreMapper;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreStatus;
import com.southsystem.desafiobackvotos.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Score create(ScoreCreateDto scoreCreate) {
        return scoreRepository.save(ScoreMapper.toEntity(scoreCreate));
    }

    public Score open(ScoreOpenDto scoreOpenDto) {
        Score referenceScore = findById(scoreOpenDto.getScoreId());

        referenceScore.setScoreStatus(ScoreStatus.OPEN);
        referenceScore.setOpenAt(LocalDateTime.now());
        referenceScore.setCloseAt(buildScoreCloseDate(scoreOpenDto.getDurationInMinutes()));

        return scoreRepository.save(referenceScore);
    }

    public Score findById(String scoreId) {
        return scoreRepository.findById(scoreId)
                .orElseThrow(() -> new ScoreNotFoundException(scoreId));
    }

    private LocalDateTime buildScoreCloseDate(Long durationInMinutes) {
        if (!Objects.isNull(durationInMinutes)) {
            return LocalDateTime.now().plusMinutes(durationInMinutes);
        }

        return LocalDateTime.now().plusMinutes(1);
    }
}
