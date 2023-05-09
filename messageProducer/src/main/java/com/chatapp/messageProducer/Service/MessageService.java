package com.chatapp.messageProducer.Service;

import com.chatapp.messageProducer.model.request.SendMessageRequest;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class MessageService {

    private final Producer<String,String> producer;

    public MessageService(ProducerFactory<String,String> producerFactory){
        this.producer = producerFactory.createProducer();
    }

    public void sendMessage(SendMessageRequest sendMessageRequest) throws Exception{
        String topic = sendMessageRequest.getTopic();
        String message = sendMessageRequest.getMessage();
        String fromUser = sendMessageRequest.getFromUser();
        String toUser = sendMessageRequest.getToUser();

        ProducerRecord<String,String> producerRecord = new ProducerRecord<>(topic,message);
        producerRecord.headers().add("fromUser", fromUser.getBytes());
        producerRecord.headers().add("toUser", toUser.getBytes());
        Future<RecordMetadata> future = producer.send(producerRecord);

        try {
            RecordMetadata metadata = future.get();
            System.out.printf("Sent message to topic=%s, partition=%d, offset=%d%n",
                    metadata.topic(), metadata.partition(), metadata.offset());
        } catch (Exception e){
            System.err.println("failed to send message");
            throw e;
        }
    }

    @PreDestroy
    public void closeProducer(){
        producer.close(Duration.ofSeconds(5));
    }


}
