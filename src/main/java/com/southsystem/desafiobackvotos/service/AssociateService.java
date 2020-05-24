package com.southsystem.desafiobackvotos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southsystem.desafiobackvotos.entity.Associate;
import com.southsystem.desafiobackvotos.repository.AssociateRepository;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;

    public Associate create(String federalIdentification) {
        return associateRepository.save(createAssociate(federalIdentification));
    }

    public Optional<Associate> findByFederalIdentification(String federalIdentification) {
        return associateRepository.findByFederalIdentification(federalIdentification);
    }

    private Associate createAssociate(String federalIdentification) {
        return new Associate()
                .setFederalIdentification(federalIdentification);
    }
}
