package com.tu.cloud02.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.tu.cloud02.handler.CommonHandler;
import com.tu.cloud02.services.SentinelProviderServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/client")
public class SentinelOpenFeignController {

    @Resource
    private SentinelProviderServices sentinelProviderServices;


    @GetMapping("/dohello")
    @SentinelResource(value = "dohello",
            blockHandler = "blockException", blockHandlerClass = CommonHandler.class,
            fallback = "fallbackException", fallbackClass = CommonHandler.class)
    public String dohello(){

        return sentinelProviderServices.doSOHello();
    }

}
