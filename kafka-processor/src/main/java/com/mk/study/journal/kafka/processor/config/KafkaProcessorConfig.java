package com.mk.study.journal.kafka.processor.config;

import com.mk.study.journal.kafka.processor.model.Message;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class KafkaProcessorConfig {

    @Bean
    public Function<KStream<String, Message>, KStream<String, Message>> kafkaProcessor(){
        return kstream -> kstream.filter((key, message) -> {
            if(message.getMessageText().equals("Welcome")){
                System.out.println("Welcome in Kafka Streaming.");
            } else {
                System.out.println("Hello");
            }
            return true;
        });
    }
}
