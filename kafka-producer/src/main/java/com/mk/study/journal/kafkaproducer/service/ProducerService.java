package com.mk.study.journal.kafkaproducer.service;

import com.mk.study.journal.kafkaproducer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProducerService {

    private final String KAFKA_TOPIC = "KAFKA_PRODUCERS";
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public String getKafkaMessage() {
        List<Message> list = new ArrayList<>();
        list.add(getMessage("Id_1", "Hello Message", "Hello"));
        list.add(getMessage("Id_2", "2nd Hello Message", "2nd Hello"));
        list.forEach(message -> {
            kafkaTemplate.send(KAFKA_TOPIC, message);
        });
        return "message successfully sent.";
    }

    private Message getMessage(String id, String text, String subject){
        Message message = new Message();
        message.setMessageId(id);
        message.setMessageText(text);
        message.setMessageSubject(subject);
        return message;
    }
}
