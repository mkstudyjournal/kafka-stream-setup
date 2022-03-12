package com.mk.study.journal.kafkaproducer;

import com.mk.study.journal.kafkaproducer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/message")
    public String getMessage(){
        return producerService.getKafkaMessage();
    }
}
