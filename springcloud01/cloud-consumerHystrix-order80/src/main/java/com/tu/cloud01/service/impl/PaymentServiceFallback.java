package com.tu.cloud01.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentServiceFallback implements PaymentService {

    public CommonResult getPaymentById(Integer id) {
        return new CommonResult(999, "程序处理异常或超时，公共处理方法");
    }
}
