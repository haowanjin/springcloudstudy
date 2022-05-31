package com.ddup.springcloud;

import com.ddup.springcloud.config.RocketMQProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/5/25 14:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RibbonTest {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RocketMQProducer rocketMQProducer;

    @Test
    public void test2() throws IOException {
        loadBalancerClient.execute("payment-service", new LoadBalancerRequest<Object>() {
            @Override
            public Object apply(ServiceInstance instance) throws Exception {
                return null;
            }
        });
    }

    @Test
    public void test1() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message message = new Message("testTopic", "tag", "hello rocketmq".getBytes(StandardCharsets.UTF_8));
        SendResult send = rocketMQProducer.getProducer().send(message);
        System.out.println(send);
    }

}
