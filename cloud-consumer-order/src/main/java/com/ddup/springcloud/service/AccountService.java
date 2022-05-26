package com.ddup.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/4/22 15:49
 */
@FeignClient(name = "cloud-payment-service")
public interface AccountService {
    @GetMapping(value = "/account/transferFrom")
    String transferFrom(@RequestParam("amount") BigDecimal amount);

    @GetMapping(value = "/account/transferTo")
    String transferTo(@RequestParam("amount") BigDecimal amount);

}
