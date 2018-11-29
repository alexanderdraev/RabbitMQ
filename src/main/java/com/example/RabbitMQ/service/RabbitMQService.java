package com.example.RabbitMQ.service;

import com.example.RabbitMQ.model.Employee;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.RabbitMQ.config.RabbitMQConfig.EXCHANGE_NAME;
import static com.example.RabbitMQ.config.RabbitMQConfig.ROUTINGKEY_NAME;

@Service
public class RabbitMQService {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void send(Employee company) {
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTINGKEY_NAME, company);
        System.out.println("Send msg = " + company);

    }
}
