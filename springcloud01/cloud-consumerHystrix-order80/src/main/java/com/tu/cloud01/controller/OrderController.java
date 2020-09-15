package com.tu.cloud01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    public PaymentService paymentService;

    @GetMapping("/payment/getPaymentById/{id}")
//    @HystrixCommand(fallbackMethod = "orderFallbackMethod", commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "2000")
//    })
    public CommonResult getPaymentById(@PathVariable("id") Integer id){

//        try {
//            TimeUnit.MILLISECONDS.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        CommonResult result = paymentService.getPaymentById(id);

        return result;
    }

    public CommonResult orderFallbackMethod(Integer id){

        return new CommonResult(999, "Hystrix程序异常或超时", id);
    }
}
