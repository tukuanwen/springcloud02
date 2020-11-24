package com.tu.cloud02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentinelOpenFeignMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelOpenFeignMain9003.class, args);
    }
}
