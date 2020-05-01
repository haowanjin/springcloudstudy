package com.ddup.springcloud.service;

import com.ddup.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int creat(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
