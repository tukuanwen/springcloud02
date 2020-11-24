package com.tu.cloud01.dao;

import com.tu.cloud01.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PaymentMapper {

    public int incrPayment(Payment payment);

    public Payment getPayment(@Param("id") Integer id);

}
