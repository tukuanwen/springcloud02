package com.tu.cloud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Paymentzk8003 {

    public static void main(String[] args) {
        SpringApplication.run(Paymentzk8003.class, args);
    }
}
