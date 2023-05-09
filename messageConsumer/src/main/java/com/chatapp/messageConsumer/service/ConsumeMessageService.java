package com.chatapp.messageConsumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumeMessageService {

    @KafkaListener(topics = "message")
    public void consume(ConsumerRecord<String, String> record){

        String message = record.value();
        String fromUser = new String(record.headers().lastHeader("fromUser").value());
        String toUser = new String(record.headers().lastHeader("toUser").value());

        System.out.println("Received message: " + message + ", from user: " + fromUser + ", to user: " + toUser);
    }
}
