package com.southsystem.desafiobackvotos.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.entity.ScoreStatus;

public interface ScoreSearchRepository {

    @Query("SELECT score.id FROM Score score"
            + " WHERE score.closeAt <= :closeAtReference"
            + " AND score.scoreStatus = :scoreStatus")
    List<String> findCurrentScoresToClose(@Param("closeAtReference") LocalDateTime closeAtReference, @Param("scoreStatus") ScoreStatus scoreStatus);

    @Query("SELECT score FROM Score score"
            + " LEFT JOIN FETCH score.scoreVotes "
            + " LEFT JOIN FETCH score.scoreClose "
            + " WHERE score.id = :scoreId"
            + " AND score.scoreStatus = :scoreStatus")
    Optional<Score> findOpenById(@Param("scoreId") String scoreId, @Param("scoreStatus") ScoreStatus scoreStatus);
}
