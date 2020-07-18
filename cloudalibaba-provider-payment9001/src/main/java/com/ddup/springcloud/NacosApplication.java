package com.ddup.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication {
    public static void main(String[] args) {
        ConcurrentHashMap hs = new ConcurrentHashMap();
        hs.put(null, "aaaa");
       // SpringApplication.run(NacosApplication.class, args);
    }
}
