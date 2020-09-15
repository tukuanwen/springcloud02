package com.tu.cloud01.services.impl;

import com.tu.cloud01.dao.PaymentMapper;
import com.tu.cloud01.entities.Payment;
import com.tu.cloud01.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    public PaymentMapper paymentMapper;

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentMapper.getPaymentById(id);
    }

    @Override
    public int incrPayment(Payment payment) {
        return paymentMapper.incrPayment(payment);
    }
}
