package com.mk.study.journal.kafka.consumer.config;

import com.mk.study.journal.kafka.consumer.model.Message;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public Consumer<KStream<String, Message>> kafkaConsumer(){
        return kstream -> kstream.foreach((key, message) -> {
            System.out.println("Message consumed"+ message);
        });
    }
}
