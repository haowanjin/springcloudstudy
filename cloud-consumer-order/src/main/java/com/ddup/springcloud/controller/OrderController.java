package com.ddup.springcloud.controller;

import com.ddup.springcloud.entities.CommonResult;
import com.ddup.springcloud.entities.Payment;

import com.ddup.springcloud.loadbalancer.ILoadBalancer;
import com.ddup.springcloud.service.ZkAccountService;
import com.ddup.springcloud.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
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
    @Autowired
    private ZkAccountService zkAccountService;
    @Autowired
    private AccountServiceImpl accountServiceImpl;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

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

    @GetMapping("transfer")
    public String transfer(@RequestParam("amount") BigDecimal amount) {
        String s = accountServiceImpl.transfer(amount);
        return "SUCCESS" + s;
    }

    @GetMapping("zkTest")
    public String zkTest() {
        return zkAccountService.testZkClient();
    }

    @GetMapping("ribbon")
    public Object ribbonTest() {
        ServiceInstance service = loadBalancerClient.choose("CLOUD-PAYMENT-SERVICE");
        System.out.println(service.getUri());
        System.out.println(service.getServiceId());
        System.out.println(service.getHost());
        return service.getUri();
    }
}
