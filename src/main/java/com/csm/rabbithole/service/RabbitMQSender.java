package com.csm.rabbithole.service;

import com.csm.rabbithole.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Value("${rabbithole.rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbithole.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company){

        amqpTemplate.convertAndSend(exchange,routingkey,"message here".getBytes());
        System.out.println("Send msg = " + company.toString().getBytes());
    }
}
