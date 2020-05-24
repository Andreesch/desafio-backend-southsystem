package com.southsystem.desafiobackvotos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.southsystem.desafiobackvotos.entity.ScoreVote;

public interface ScoreVoteSearchRepository {

    @Query("SELECT sv FROM ScoreVote sv"
            + " JOIN sv.associate a"
            + " JOIN sv.score s"
            + " WHERE a.federalIdentification = :federalIdentification"
            + " AND s.id = :scoreId")
    public Optional<ScoreVote> findByAssociateFedIdAndScoreId(@Param("federalIdentification") String federalIdentification,
            @Param("scoreId") String scoreId);
}
