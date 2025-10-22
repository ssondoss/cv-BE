package com.cvbuilder.auth.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue cvQueue(){
        return new Queue("cv-generation-queue", true);
    }

    @Bean
    public TopicExchange exchange1(){
        return new TopicExchange("PdfExchange");
    }

    @Bean
    Binding binding1(){
        return BindingBuilder.bind(cvQueue()).
                to(exchange1()).with("pdf.*");
    }
}
