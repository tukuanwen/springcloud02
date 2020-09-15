package com.tu.cloud01.controller;


import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consumer")
public class PaymentController {

    @Autowired
    private PaymentServices paymentServices;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/getPayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Integer id) {
        return paymentServices.getPayment(id);
    }


    /**
     * 模拟feign超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // openfeign-ribbon, 客户端一般默认等待1秒钟
        return paymentServices.paymentFeignTimeout();
    }


}