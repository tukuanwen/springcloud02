package com.tu.cloud02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosClientMain9001 {

    public static void main(String[] args) {
//        System.setProperty("nacos.standalone", "true");
        SpringApplication.run(NacosClientMain9001.class, args);
    }

}
