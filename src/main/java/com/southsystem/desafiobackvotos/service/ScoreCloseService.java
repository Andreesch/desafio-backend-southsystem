package com.southsystem.desafiobackvotos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.desafiobackvotos.api.exception.ScoreNotFoundException;
import com.southsystem.desafiobackvotos.api.mapper.ScoreCloseMapper;
import com.southsystem.desafiobackvotos.api.message.ScoreMessageSender;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreClose;
import com.southsystem.desafiobackvotos.entity.ScoreStatus;
import com.southsystem.desafiobackvotos.repository.ScoreCloseRepository;

@Service
public class ScoreCloseService {

    @Autowired
    private ScoreCloseRepository scoreCloseRepository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreMessageSender scoreMessageSender;

    public void closeScore(String scoreId) {
        Score referenceScore = scoreService.findByIdWithVotes(scoreId);

        ScoreClose scoreClose = scoreCloseRepository.save(ScoreCloseMapper.toEntity(referenceScore));

        updateScore(referenceScore);

        scoreMessageSender.sendScoreMessage(ScoreCloseMapper.toMessageVO(scoreClose));
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public ScoreClose findByScore(String scoreId) {
        return scoreCloseRepository.findByReferenceScore(scoreId)
                .orElseThrow(() -> new ScoreNotFoundException(scoreId));
    }

    public List<ScoreClose> findAll() {
        return scoreCloseRepository.findAll();
    }

    private void updateScore(Score referenceScore) {
        referenceScore.setScoreStatus(ScoreStatus.CLOSED);
        scoreService.updateScore(referenceScore);
    }

}
