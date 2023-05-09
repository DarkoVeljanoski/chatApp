package com.chatapp.messageProducer.controller;

import com.chatapp.messageProducer.Service.MessageService;
import com.chatapp.messageProducer.model.request.SendMessageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody SendMessageRequest sendMessageRequest) throws Exception {
        messageService.sendMessage(sendMessageRequest);
        return ResponseEntity.ok("Message sent to kafka topic: " + sendMessageRequest.getTopic());
    }
}
