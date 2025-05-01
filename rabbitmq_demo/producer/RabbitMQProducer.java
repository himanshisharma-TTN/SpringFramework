package com.rabbitmq.rabbitmq_demo.producer;

import com.rabbitmq.rabbitmq_demo.config.RabbitMQConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendMessage(String email) {
        amqpTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, email);
        System.out.println("Register user with : " + email);
    }
}
