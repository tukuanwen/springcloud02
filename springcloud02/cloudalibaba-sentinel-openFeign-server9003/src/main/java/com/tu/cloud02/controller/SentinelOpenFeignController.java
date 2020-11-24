package com.tu.cloud02.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tu.cloud02.handler.CommonHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class SentinelOpenFeignController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String portStr;

    @GetMapping("/dohello")
//    @SentinelResource(value = "dohello",
//            blockHandler = "blockException", blockHandlerClass = CommonHandler.class,
//            fallback = "fallbackException", fallbackClass = CommonHandler.class)
    public String doSOHello(){

        return "Sentinel整合OpenFeign框架，综合型框架，服务信息为："+configInfo+":"+portStr;
    }

//    public String blockException(BlockException exception){
//
//        return "block系统限流异常，公共拦截配置";
//    }
//
//    public String fallbackException(){
//
//        return "fallback系统异常公共拦截配置";
//    }
}
