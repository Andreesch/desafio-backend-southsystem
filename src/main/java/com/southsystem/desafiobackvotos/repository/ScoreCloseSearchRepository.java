package com.southsystem.desafiobackvotos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.southsystem.desafiobackvotos.entity.ScoreClose;

public interface ScoreCloseSearchRepository {

    @Query("SELECT scoreClose FROM ScoreClose scoreClose"
            + " JOIN FETCH scoreClose.score score"
            + " WHERE score.id <= :referenceScoreId")
    Optional<ScoreClose> findByReferenceScore(@Param("referenceScoreId") String referenceScoreId);
}
