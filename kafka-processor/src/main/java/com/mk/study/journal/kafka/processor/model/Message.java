package com.mk.study.journal.kafka.processor.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Message {

    private String messageId;
    private String messageSubject;
    private String messageText;

}
