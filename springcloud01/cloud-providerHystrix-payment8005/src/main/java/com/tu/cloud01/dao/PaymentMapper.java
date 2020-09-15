package com.tu.cloud01.dao;

import com.tu.cloud01.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PaymentMapper {

    public Payment getPaymentById(Integer id);
    public int incrPayment(Payment payment);

}
