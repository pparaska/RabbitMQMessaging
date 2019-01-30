package com.cg.app.rabbitMQDemoReceiver.receiver;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @RabbitListener(queues = "CustomerQ")
    public void processMessage(String message) {
        System.out.println(message + " Received");
    }
 
}