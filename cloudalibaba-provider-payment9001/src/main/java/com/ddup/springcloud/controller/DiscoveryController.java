package com.ddup.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ddup.springcloud.entities.CommonResult;
import com.ddup.springcloud.myhandle.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("discovery")
@RefreshScope
@Slf4j
public class DiscoveryController {
    @Value("${config.message}")
    private String configInfo;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("info")
    public String configInfo() {
        System.out.println(profile);
        return configInfo;
    }

    @GetMapping("testA")
    public String testA() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("测试 RT 降级");
        return "testA, 测试 RT 降级";
    }

    @GetMapping("testB")
    public String testB() {
        log.info("测试异常比例降级");
        int a = 10 / 0;
        return "testB, 测试异常比例降级";
    }

    @GetMapping("testC")
    public String testC() {
        log.info("测试异常数");
        int a = 10 / 0;
        return "testB, 测试异常数降级";
    }

    @GetMapping("testHotKey")
    @SentinelResource(value = "testHotKey",blockHandlerClass = GlobalException.class,blockHandler = "handlerException1")
    public CommonResult testHotKey(@RequestParam(value = "p1", required = false) String p1,
                                   @RequestParam(value = "p2", required = false) String p2) {
        return new CommonResult(200,"成功。。。。。。","\"-------testHotKey\"");
    }

    public String dealHotKey(String p1, String p2, BlockException ex) {
        return "-------dealHotKey(),┭┮﹏┭┮";
    }
}