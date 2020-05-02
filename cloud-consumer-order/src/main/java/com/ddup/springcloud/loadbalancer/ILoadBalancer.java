package com.ddup.springcloud.loadbalancer;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface ILoadBalancer {
    ServiceInstance instance(List<ServiceInstance> instances);
}
