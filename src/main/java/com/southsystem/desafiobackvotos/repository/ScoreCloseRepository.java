package com.southsystem.desafiobackvotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.southsystem.desafiobackvotos.entity.ScoreClose;

@Repository
public interface ScoreCloseRepository extends JpaRepository<ScoreClose, String> {
}
