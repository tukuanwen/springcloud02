package com.tu.dubbozkprovider.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.tu.dubbozkprovider.services.MistraService;

@Service(version = "${mistra.service.version}")
public class MistraServiceImpl implements MistraService {
    @Override
    public String welcome(String name) {
        return "Hello" + name;
    }
}
