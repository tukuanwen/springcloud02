package com.tu.cloud02.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowLimitController {

    @SentinelResource(value = "testA", fallback = "fallbackExcption")
    @GetMapping("/testA")
    public String testA() {
        return "testA";
    }
    @SentinelResource(value = "testB", blockHandler = "handleException")
    @GetMapping("/testB")
    public String testB() {
        int a = 10 / 0;

        String aa = "实现自动重启----------------";

        return "testB";

    }


    public String handleException(BlockException exception){
        return "流控限制的兜底方案：目前服务忙，请稍后再试！";
    }

    public String fallbackExcption(){
        return "fallbackException：服务异常请稍后再试！";
    }

}
