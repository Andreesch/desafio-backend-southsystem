package com.southsystem.desafiobackvotos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.southsystem.desafiobackvotos.api.dto.ScoreCreateDto;
import com.southsystem.desafiobackvotos.api.dto.ScoreResponseDto;
import com.southsystem.desafiobackvotos.api.mapper.ScoreMapper;
import com.southsystem.desafiobackvotos.entity.Score;
import com.southsystem.desafiobackvotos.repository.ScoreRepository;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Score create(ScoreCreateDto scoreCreate) {
        return scoreRepository.save(ScoreMapper.toEntity(scoreCreate));
    }
}
