package com.ddup.springcloud.dao;

import com.ddup.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
