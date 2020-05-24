package com.southsystem.desafiobackvotos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.southsystem.desafiobackvotos.entity.Associate;

@Repository
public interface AssociateRepository extends JpaRepository<Associate, String> {
}
