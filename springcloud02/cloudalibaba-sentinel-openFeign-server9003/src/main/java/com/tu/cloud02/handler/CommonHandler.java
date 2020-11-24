package com.tu.cloud02.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

//服务降级，兜底服务处理,内部方法必须是static修饰
public class CommonHandler {

    public static String blockException(BlockException exception){

        return "block系统限流异常，公共拦截配置";
    }

    public static String fallbackException(){

        return "fallback系统异常公共拦截配置";
    }
}
