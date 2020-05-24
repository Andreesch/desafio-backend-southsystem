package com.southsystem.desafiobackvotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.southsystem.desafiobackvotos.repository.AssociateRepository;

@Service
public class AssociateService {

    @Autowired
    private AssociateRepository associateRepository;


}
