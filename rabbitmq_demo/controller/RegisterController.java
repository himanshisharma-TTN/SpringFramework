package com.rabbitmq.rabbitmq_demo.controller;

import com.rabbitmq.rabbitmq_demo.consumer.RabbitMQConsumer;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterController {

    @Autowired
    private RabbitMQConsumer rabbitMQConsumer;

    @GetMapping("/register")
    public String register(@RequestParam String email) {
        rabbitMQConsumer.receiveMessage(email);
        return "User Registered Successfully";
    }
}
