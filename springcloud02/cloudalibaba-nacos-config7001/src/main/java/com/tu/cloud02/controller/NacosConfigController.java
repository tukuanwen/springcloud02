package com.tu.cloud02.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class NacosConfigController {

    @Value("${config.commonInfo}")
    private String commonInfo;

    @GetMapping("/doConfigInfo")
    public String doConfigInfo(){

        return "config配置信息中参数："+commonInfo;
    }
}
