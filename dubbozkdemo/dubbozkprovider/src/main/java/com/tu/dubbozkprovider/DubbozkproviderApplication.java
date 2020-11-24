package com.tu.dubbozkprovider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DubbozkproviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbozkproviderApplication.class, args);
    }

}
