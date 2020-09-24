package com.tu.cloud02.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException", fallback = "fallbackException")
    public String byResource(){

        int a = 10 / 0;
        return "访问正常，正确返回！";
    }

    public String handleException(BlockException blockerException){

        return blockerException.getClass().getCanonicalName()+":限流拦截，自定义返回信息！";
    }

    public String fallbackException(){

        String fallStr = "kkkkkkkkkkkkkkkkkkkkkkkkkk";

        String kehuduan = "客户端进行了修改";

        return "程序异常，主动降级！";
    }

}
