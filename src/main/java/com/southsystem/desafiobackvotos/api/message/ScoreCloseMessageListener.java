package com.southsystem.desafiobackvotos.api.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.southsystem.desafiobackvotos.config.RabbitConfig;
import com.southsystem.desafiobackvotos.service.ScoreCloseService;
import com.southsystem.desafiobackvotos.service.vo.ScoreCloseListVO;

@Component
public class ScoreCloseMessageListener {
   private static final Logger logger = LoggerFactory.getLogger(ScoreCloseMessageListener.class);

   @Autowired
   private ScoreCloseService scoreCloseService;

    @RabbitListener(queues = RabbitConfig.SCORE_CLOSE_QUEUE)
    public void processScoresToClose(ScoreCloseListVO scoreCloseListVO) {
        logger.info("Fechando as pautas");

        scoreCloseListVO.getScoresToCloseList()
                .forEach(id -> scoreCloseService.closeScore(id));
    }
}
