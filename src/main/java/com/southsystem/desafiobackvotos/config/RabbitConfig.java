package com.southsystem.desafiobackvotos.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String SCORE_QUEUE = "scores-queue";
    public static final String SCORE_CLOSE_QUEUE = "scores-close-queue";
    public static final String SCORE_EXCHANGE = "scores-exchange";
    public static final String SCORE_CLOSE_EXCHANGE = "scores-close-exchange";

    @Bean
    Queue scoreQueue() {
        return QueueBuilder.durable(SCORE_QUEUE)
                .build();
    }

    @Bean
    Queue scoreCloseQueue() {
        return QueueBuilder.durable(SCORE_CLOSE_QUEUE)
                .build();
    }

    @Bean
    Exchange scoreExchange() {
        return ExchangeBuilder.topicExchange(SCORE_EXCHANGE)
                .build();
    }

    @Bean
    Exchange scoreCloseExchange() {
        return ExchangeBuilder.topicExchange(SCORE_CLOSE_EXCHANGE)
                .build();
    }

    @Bean
    Binding bindingScoreQueue(Queue scoreQueue, TopicExchange scoreExchange) {
        return BindingBuilder.bind(scoreQueue)
                .to(scoreExchange)
                .with(SCORE_QUEUE);
    }

    @Bean
    Binding bindingScoreCloseQueue(Queue scoreCloseQueue, TopicExchange scoreCloseExchange) {
        return BindingBuilder.bind(scoreCloseQueue)
                .to(scoreCloseExchange)
                .with(SCORE_CLOSE_QUEUE);
    }

}
