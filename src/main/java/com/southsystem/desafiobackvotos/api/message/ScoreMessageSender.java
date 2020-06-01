package com.southsystem.desafiobackvotos.api.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.southsystem.desafiobackvotos.config.EventConfig;
import com.southsystem.desafiobackvotos.config.RabbitConfig;
import com.southsystem.desafiobackvotos.service.vo.ScoreCloseListVO;
import com.southsystem.desafiobackvotos.service.vo.ScoreCloseMessageVO;

@Service
public class ScoreMessageSender {
    private static final Logger LOG = LoggerFactory.getLogger(ScoreMessageSender.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void closeScoreMessage(ScoreCloseListVO scoreCloseListVO) {
        rabbitTemplate.convertAndSend(RabbitConfig.SCORE_CLOSE_QUEUE, scoreCloseListVO);
    }

    public void sendScoreMessage(ScoreCloseMessageVO scoreCloseMessageVO) {
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.SCORE_QUEUE, objectMapper.writeValueAsString(scoreCloseMessageVO));
        } catch (JsonProcessingException e) {
            LOG.info("Erro no parser do objeto a ser enviado para o tópico de pautas fechadas.");
        }
    }
}
