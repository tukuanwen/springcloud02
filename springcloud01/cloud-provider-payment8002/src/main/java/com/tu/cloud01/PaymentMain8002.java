package com.tu.cloud01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class PaymentMain8002 {

    //项目启动入口
    public static void main(String[] args) {

        SpringApplication.run(PaymentMain8002.class, args);
    }
}
