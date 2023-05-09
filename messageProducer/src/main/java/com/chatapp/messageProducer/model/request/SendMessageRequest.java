package com.chatapp.messageProducer.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMessageRequest {

    private String topic;
    private String message;
    private String fromUser;
    private String toUser;
}
