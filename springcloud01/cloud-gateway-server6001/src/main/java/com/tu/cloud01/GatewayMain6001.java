package com.tu.cloud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain6001 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain6001.class, args);
    }
}
