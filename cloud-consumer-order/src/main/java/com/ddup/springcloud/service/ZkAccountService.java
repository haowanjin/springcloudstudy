package com.ddup.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/5/24 9:55
 */
@FeignClient(name = "zookeeper-payment-service")
public interface ZkAccountService {
    @GetMapping(value = "/zookeeper/test")
    String testZkClient();
}
