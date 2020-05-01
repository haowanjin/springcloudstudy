package com.ddup.springcloud.controller;

import com.ddup.springcloud.entities.CommonResult;
import com.ddup.springcloud.entities.Payment;
import com.ddup.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("creat")
    public CommonResult<Object> create(@RequestBody Payment payment) {
        int res = paymentService.creat(payment);
        if (res > 0) {
            log.info("*****插入数据成功******");
            return new CommonResult<>(200, "插入数据成功, ServerPort: " + port, res);
        } else {
            log.info("*****插入数据失败******");
            return new CommonResult<>(444, "插入数据失败, ServerPort: " + port, null);
        }
    }

    @GetMapping("getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            log.info("查到了。。。。。");
            return new CommonResult<>(200, "查询成功, ServerPort: " + port, payment);
        } else {
            log.info("没查到啊。。。。。");
            return new CommonResult<>(444, "没有对应记录,查询id:" + id + " ServerPort: " + port, null);
        }
    }

    @RequestMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*********service: " + service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t"
                    + instance.getHost() + "\t"
                    + instance.getPort() + "\t"
                    + instance.getUri());
        }
        return this.discoveryClient;
    }
}
