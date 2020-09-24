package com.tu.cloud02.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProviderConnectionServer {

    public static String PROVIDER_URL_STR = "http://cloudalibaba-nacos-provider";

    @Autowired
    private RestTemplate restTemplate;

    public String consumerToProvider(){

        return restTemplate.getForObject(PROVIDER_URL_STR+"/provider/echo/kehuduan", String.class, "客户端参数");
    }


}
