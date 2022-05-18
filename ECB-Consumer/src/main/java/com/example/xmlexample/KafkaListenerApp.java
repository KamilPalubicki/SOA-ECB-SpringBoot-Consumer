package com.example.xmlexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;


@SpringBootApplication
public class KafkaListenerApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaListenerApp.class, args);
    }

    boolean fail = true;

    @KafkaListener(topics = "currenciesEx", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }


}
