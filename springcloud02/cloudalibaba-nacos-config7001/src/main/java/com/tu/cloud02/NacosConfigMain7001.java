package com.tu.cloud02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NacosConfigMain7001 {

    public static void main(String[] args) {
//        System.setProperty("nacos.standalone", "true");
        SpringApplication.run(NacosConfigMain7001.class, args);
    }
}
