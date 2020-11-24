package com.tu.dubbozkapi.services.impl;

import com.tu.dubbozkapi.services.DubbozkServer;

public class DubbozkServerImpl implements DubbozkServer {
    @Override
    public String sayHello(String content) {

        return "Hello dubbo : " + content;
    }
}
