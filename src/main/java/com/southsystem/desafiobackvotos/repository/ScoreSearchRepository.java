package com.southsystem.desafiobackvotos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreSearchRepository {

    @Query("SELECT score.id FROM Score score"
            + " WHERE score.closeAt <= :closeAtReference")
    List<String> findCurrentScoresToClose(@Param("closeAtReference") LocalDateTime closeAtReference);
}
