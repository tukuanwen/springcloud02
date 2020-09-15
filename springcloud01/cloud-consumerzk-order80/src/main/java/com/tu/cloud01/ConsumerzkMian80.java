package com.tu.cloud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkMian80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerzkMian80.class, args);
    }
}
