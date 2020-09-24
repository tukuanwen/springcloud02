package com.tu.cloud02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class StreamConsumerController {

    @Value("${services.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void doConsumer(Message<String> message){

        System.out.println("端口号为："+serverPort+"收到的消息为："+message.getPayload());
    }

}
