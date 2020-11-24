package com.tu.cloud01.service;

import com.tu.cloud01.dao.PaymentMapper;
import com.tu.cloud01.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl {

    @Autowired
    public PaymentMapper paymentMapper;

    public int incrPayment(Payment payment){

        return paymentMapper.incrPayment(payment);
    }

    public Payment getPayment(Integer id){

        return paymentMapper.getPayment(id);
    }

}
