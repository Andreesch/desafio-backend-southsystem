package com.southsystem.desafiobackvotos.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.southsystem.desafiobackvotos.entity.Score;

public interface ScoreSearchRepository {

    @Query("SELECT score.id FROM Score score"
            + " WHERE score.closeAt <= :closeAtReference")
    List<String> findCurrentScoresToClose(@Param("closeAtReference") LocalDateTime closeAtReference);

    @Query("SELECT score FROM Score score"
            + " JOIN FETCH score.scoreVotes "
            + " WHERE score.id = :scoreId")
    Optional<Score> findByIdWithVotes(@Param("scoreId") String scoreId);
}
