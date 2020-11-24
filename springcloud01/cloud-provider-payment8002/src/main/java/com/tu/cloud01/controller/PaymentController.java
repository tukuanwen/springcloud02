package com.tu.cloud01.controller;

import com.tu.cloud01.entities.CommonResult;
import com.tu.cloud01.entities.Payment;
import com.tu.cloud01.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    public PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/incrPayment")
    public CommonResult incrPayment(@RequestBody Payment payment){
        CommonResult cresult = null;
        int result = paymentService.incrPayment(payment);

        System.out.println("插入后的ID为："+result);
        if(result > 0){
            cresult = new CommonResult(200, "数据插入成功，服务端口号："+serverPort, result);
        }else{
            cresult = new CommonResult(444, "数据插入失败，服务端口号："+serverPort, null);
        }
        return cresult;
    }

    @GetMapping("/getPayment")
    public CommonResult<Payment> getPayment(@RequestParam("id") Integer id){

        CommonResult cresult = null;
        Payment payment = paymentService.getPayment(id);

        if(null != payment){
            cresult = new CommonResult(200, "查询数据成功，服务端口号："+serverPort, payment);
        }else{
            cresult = new CommonResult(444, "查询数据失败，服务端口号："+serverPort, null);
        }
        return cresult;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            // 暂停3秒钟 模拟超时任务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;

    }
}
