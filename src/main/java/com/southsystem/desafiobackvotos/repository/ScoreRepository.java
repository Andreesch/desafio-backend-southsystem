package com.southsystem.desafiobackvotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.southsystem.desafiobackvotos.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, String>, ScoreSearchRepository {
}
