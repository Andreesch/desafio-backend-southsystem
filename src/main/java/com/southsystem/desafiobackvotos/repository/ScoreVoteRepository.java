package com.southsystem.desafiobackvotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.southsystem.desafiobackvotos.entity.ScoreVote;

@Repository
public interface ScoreVoteRepository extends JpaRepository<ScoreVote, String>, ScoreVoteSearchRepository {
}
