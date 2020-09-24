package com.tu.cloud02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class NacosClientController {

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string, String khdStr) {

        if(null != khdStr && !"".equals(khdStr))
        {
            System.out.println("客户端传输过来的参数为："+khdStr);
        }else{
            System.out.println("客户端的参数为空");
        }
        return "Hello Nacos Discovery " + string;
    }

}
