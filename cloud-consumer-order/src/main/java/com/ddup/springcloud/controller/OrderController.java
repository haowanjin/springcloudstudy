package com.ddup.springcloud.controller;

import com.ddup.springcloud.entities.CommonResult;
import com.ddup.springcloud.entities.Payment;

import com.ddup.springcloud.loadbalancer.ILoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
@Slf4j
public class OrderController {
    private final static String PAYMENT_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ILoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("getPayment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        log.info("调用微服务成功");
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        ServiceInstance instance = loadBalancer.instance(instances);

        return restTemplate.getForObject(instance.getUri() + "/payment/getPaymentById/" + id, CommonResult.class);
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommonResult.class);
    }

    @GetMapping("/creat")
    public CommonResult<Payment> creatPayment(Payment payment) {
        log.info("创建成功");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/creat", payment, CommonResult.class);
    }
}
