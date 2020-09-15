package com.tu.cloud01.controller;

import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class PaymentController {

//    public final static String PAYMENT_URL = "http://localhost:8001";
//    采用eureka来管理服务
    public final static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/getPayment")
    public CommonResult<Payment> getPyment(@RequestParam("id") Integer id){

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPayment?id="+id, CommonResult.class, id);

        return forEntity.getBody();
    }

}
