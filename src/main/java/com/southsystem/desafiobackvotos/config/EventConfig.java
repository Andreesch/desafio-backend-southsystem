package com.southsystem.desafiobackvotos.config;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.southsystem.desafiobackvotos.api.message.ScoreMessageSender;
import com.southsystem.desafiobackvotos.service.ScoreService;
import com.southsystem.desafiobackvotos.service.vo.ScoreCloseListVO;

@Component
public class EventConfig {
    private static final Logger LOG = LoggerFactory.getLogger(EventConfig.class);

    @Autowired
    private ScoreService scoreService;

    @Autowired
    private ScoreMessageSender scoreMessageSender;

    @Scheduled(fixedRate = 60000)
    public void create() {
        LOG.info("Buscando pautas a serem fechadas");

        List<String> currentScoresToClose = scoreService.findCurrentScoresToClose(LocalDateTime.now());

        if (!currentScoresToClose.isEmpty()) {
            LOG.info("Quantidade de pautas a serem fechadas: " + currentScoresToClose.size());

            ScoreCloseListVO scoreCloseListVO = new ScoreCloseListVO()
                    .setScoresToCloseList(currentScoresToClose);

            scoreMessageSender.closeScoreMessage(scoreCloseListVO);
        }
    }

}
