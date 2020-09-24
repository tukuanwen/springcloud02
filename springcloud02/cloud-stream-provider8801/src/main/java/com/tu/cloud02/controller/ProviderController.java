package com.tu.cloud02.controller;

import com.tu.cloud02.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/stream")
public class ProviderController {

    @Autowired
    private IMessageProvider iMessageProvider;

    @GetMapping("/dosend")
    public String doSend(){

        iMessageProvider.send();

        return "刷新"+ UUID.randomUUID().toString();
    }

}
