package com.ddup.springcloud;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/5/25 14:31
 */
@SpringBootTest
public class RibbonTest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Test
    public void test1() {
    }

}
