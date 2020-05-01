package com.ddup.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("zookeeper")
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("test")
    public String test() {
        return "springCloud with Zookeeper: " + port + "\t" + UUID.randomUUID().toString();
    }
}
