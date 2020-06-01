package com.southsystem.desafiobackvotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Score referenceScore = scoreService.findById(scoreId);

        ScoreClose scoreClose = scoreCloseRepository.save(ScoreCloseMapper.toEntity(referenceScore));

        updateScore(referenceScore);

        scoreMessageSender.sendScoreMessage(ScoreCloseMapper.toMessageVO(scoreClose));
    }

    private void updateScore(Score referenceScore) {
        referenceScore.setScoreStatus(ScoreStatus.CLOSED);
        scoreService.updateScore(referenceScore);
    }

}
