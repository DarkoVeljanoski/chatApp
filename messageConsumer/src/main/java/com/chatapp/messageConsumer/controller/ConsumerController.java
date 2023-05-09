package com.chatapp.messageConsumer.controller;

import com.chatapp.messageConsumer.service.ConsumeMessageService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    private ConsumeMessageService consumeMessageService;

    public ConsumerController(ConsumeMessageService consumeMessageService){
        this.consumeMessageService = consumeMessageService;
    }

    @PostMapping("/consume")
    public void consumeMessage(@RequestBody ConsumerRecord<String, String> record){
        consumeMessageService.consume(record);
    }
}
