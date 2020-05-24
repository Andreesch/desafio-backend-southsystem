package com.southsystem.desafiobackvotos.repository;

import java.util.Optional;

import com.southsystem.desafiobackvotos.entity.Associate;

public interface AssociateSearchRepository {

    Optional<Associate> findByFederalIdentification(String federalIdentification);
}
