package com.rabbitmq.rabbitmq_demo.consumer;

import com.rabbitmq.rabbitmq_demo.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String email) {
        System.out.println("User registered with : " + email);
    }
}
