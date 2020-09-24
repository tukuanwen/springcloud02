package com.tu.cloud02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServerMain6001 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServerMain6001.class, args);
    }
}
