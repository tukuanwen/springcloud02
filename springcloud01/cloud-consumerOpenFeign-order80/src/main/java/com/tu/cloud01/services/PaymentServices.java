package com.tu.cloud01.services;

import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
//@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
@FeignClient(value = "CLOUD-PAYMENTHYSTRIX-SERVICE")
public interface PaymentServices {

    @GetMapping("/payment/getPayment")
    public CommonResult<Payment> getPayment(@RequestParam("id") Integer id);

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();
}
