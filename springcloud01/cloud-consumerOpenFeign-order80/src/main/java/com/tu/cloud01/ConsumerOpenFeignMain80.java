package com.tu.cloud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class ConsumerOpenFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeignMain80.class, args);
    }
}
