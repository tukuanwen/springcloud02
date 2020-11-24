package com.tu.cloud02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SentinelOpenFeignMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenFeignMain8001.class, args);
    }
}
