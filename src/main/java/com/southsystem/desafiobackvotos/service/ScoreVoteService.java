package com.southsystem.desafiobackvotos.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southsystem.desafiobackvotos.api.dto.ScoreVoteCreateDto;
import com.southsystem.desafiobackvotos.api.exception.ScoreClosedException;
import com.southsystem.desafiobackvotos.api.exception.ScoreVoteAlreadyExistsException;
import com.southsystem.desafiobackvotos.api.exception.ScoreVoteUnableToVoteException;
import com.southsystem.desafiobackvotos.client.FederalIdentificationRestClient;
import com.southsystem.desafiobackvotos.entity.AbleToVoteStatus;
import com.southsystem.desafiobackvotos.entity.Associate;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreStatus;
import com.southsystem.desafiobackvotos.entity.ScoreVote;
import com.southsystem.desafiobackvotos.repository.ScoreVoteRepository;

@Service
public class ScoreVoteService {

    @Autowired
    private ScoreVoteRepository scoreVoteRepository;

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private AssociateService associateService;

    @Autowired
    private FederalIdentificationRestClient federalIdentificationRestClient;

    public ScoreVote create(ScoreVoteCreateDto scoreVoteCreateDto) {
        Score referenceScore = scoreService.findById(scoreVoteCreateDto.getScoreId());

        validateAssociateAbleVote(referenceScore.getScoreStatus(), scoreVoteCreateDto.getFederalIdentification(),
                scoreVoteCreateDto.getScoreId());

        Associate referenceAssociate = associateService.findByFederalIdentification(scoreVoteCreateDto.getFederalIdentification())
                .orElse(associateService.create(scoreVoteCreateDto.getFederalIdentification()));

        return scoreVoteRepository.save(createScoreVote(referenceScore, referenceAssociate, scoreVoteCreateDto.getAgreed()));
    }

    private ScoreVote createScoreVote(Score score, Associate associate, Boolean agreed) {
        return new ScoreVote()
                .setScore(score)
                .setAssociate(associate)
                .setAgreed(agreed)
                .setVoteAt(LocalDateTime.now());
    }

    private void validateAssociateAbleVote(ScoreStatus scoreStatus, String federalIdentification, String scoreId) {
        if (scoreStatus.equals(ScoreStatus.CLOSED)) {
            throw new ScoreClosedException(scoreId);
        }

        if (findByFederalIdAndScoreId(federalIdentification, scoreId)
                .isPresent()) {
            throw new ScoreVoteAlreadyExistsException(federalIdentification);
        }

        if (federalIdentificationRestClient.verifyAssociateAbleVote(federalIdentification)
                .equals(AbleToVoteStatus.UNABLE_TO_VOTE)) {
            throw new ScoreVoteUnableToVoteException(federalIdentification);
        }
    }

    private Optional<ScoreVote> findByFederalIdAndScoreId(String federalIdentification, String scoreId) {
        return scoreVoteRepository.findByAssociateFedIdAndScoreId(federalIdentification, scoreId);
    }
}
