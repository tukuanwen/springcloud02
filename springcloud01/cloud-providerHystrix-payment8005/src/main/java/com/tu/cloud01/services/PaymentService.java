package com.tu.cloud01.services;

import com.tu.cloud01.entities.Payment;

public interface PaymentService {

    public Payment getPaymentById(Integer id);
    public int incrPayment(Payment payment);
}
