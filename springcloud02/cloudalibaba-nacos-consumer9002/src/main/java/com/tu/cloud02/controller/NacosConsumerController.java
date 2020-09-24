package com.tu.cloud02.controller;

import com.tu.cloud02.services.ProviderConnectionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class NacosConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private ProviderConnectionServer providerConnectionServer;

    @GetMapping("/doHello")
    public String doHello(){

        return providerConnectionServer.consumerToProvider();
    }

}
