package com.southsystem.desafiobackvotos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.desafiobackvotos.api.dto.ScoreCreateDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreOpenDto;
import com.southsystem.desafiobackvotos.api.exception.ScoreInvalidStatusException;
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

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Score open(ScoreOpenDto scoreOpenDto) {
        Score referenceScore = findById(scoreOpenDto.getScoreId());

        if (!referenceScore.getScoreStatus().equals(ScoreStatus.CREATED)) {
            throw new ScoreInvalidStatusException(referenceScore.getId());
        }

        referenceScore.setScoreStatus(ScoreStatus.OPEN);
        referenceScore.setOpenAt(LocalDateTime.now());
        referenceScore.setCloseAt(buildScoreCloseDate(scoreOpenDto.getDurationInMinutes()));

        return scoreRepository.save(referenceScore);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Score findById(String scoreId) {
        return scoreRepository.findById(scoreId)
                .orElseThrow(() -> new ScoreNotFoundException(scoreId));
    }

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Score findOpenById(String scoreId) {
        return scoreRepository.findOpenById(scoreId, ScoreStatus.OPEN)
                .orElseThrow(() -> new ScoreNotFoundException(scoreId));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<String> findCurrentScoresToClose(LocalDateTime closeAtReference) {
        return scoreRepository.findCurrentScoresToClose(closeAtReference, ScoreStatus.OPEN);
    }

    public void updateScore(Score updatedScore) {
        scoreRepository.save(updatedScore);
    }

    private LocalDateTime buildScoreCloseDate(Long durationInMinutes) {
        if (!Objects.isNull(durationInMinutes)) {
            return LocalDateTime.now().plusMinutes(durationInMinutes);
        }

        return LocalDateTime.now().plusMinutes(1);
    }
}
