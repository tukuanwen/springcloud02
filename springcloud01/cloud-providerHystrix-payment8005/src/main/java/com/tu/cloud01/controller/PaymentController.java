package com.tu.cloud01.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.entities.Payment;
import com.tu.cloud01.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class PaymentController {

    public static Integer code;
    public static String msg;

    @Autowired
    public PaymentService paymentService;


    @GetMapping("/payment/getPaymentById/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentFallBackMethond", commandProperties = {
            @HystrixProperty(name="",value="")
    })
    public CommonResult getPaymentById(@PathVariable("id") Integer id){

        Payment payment = paymentService.getPaymentById(id);

        if(null != payment){
            code = 200;
            msg = "查询成功";
        }else{
            code = 400;
            msg = "查询失败";
        }

        return new CommonResult(code, msg , payment);
    }

    //===================熔断方法调用
    @GetMapping("/payment/doCircuitBreaker/{id}")
    @HystrixCommand(fallbackMethod = "getPaymentFallBackMethond2", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),// 时间窗口期/时间范文
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")// 失败率达到多少后跳闸
    })
    public CommonResult getPaymentByIdToCircuitBreaker(@PathVariable("id") Integer id){

        if(id < 0){
            throw new RuntimeException("*****id不能是负数");
        }

        Payment payment = paymentService.getPaymentById(id);

        if(null != payment){
            code = 200;
            msg = "查询成功";
        }else{
            code = 400;
            msg = "查询失败";
        }

        return new CommonResult(code, msg , payment);
    }


    public int incrPayment(Payment payment){

        return 0;
    }

    private CommonResult getPaymentFallBackMethond(Integer id){


        return new CommonResult(999, "Hystrix异常服务熔断处理");
    }

    private CommonResult getPaymentFallBackMethond2(Integer id){


        return new CommonResult(999, "id为负数");
    }
}
