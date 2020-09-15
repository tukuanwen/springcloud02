package com.tu.cloud01.service;

import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.service.impl.PaymentServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENTHYSTRIX-SERVICE", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/getPaymentById/{id}")
//    @HystrixCommand
    public CommonResult getPaymentById(@PathVariable("id") Integer id);

//    public int incrPayment(Payment payment);

}
