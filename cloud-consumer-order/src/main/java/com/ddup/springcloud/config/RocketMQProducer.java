package com.ddup.springcloud.config;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * @author: haowanjin
 * @Description TODO
 * @create: 2022/5/30 16:52
 */
@Component
public class RocketMQProducer {
    private String producerGroup = "pay_group";
    private String nameServerAddr = "192.168.171.127:9876"; //多节点逗号分隔

    private DefaultMQProducer producer;

    public RocketMQProducer() {
        System.out.println("初始化 rocketmq producer");
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameServerAddr);
        start();
    }

    public DefaultMQProducer getProducer() {
        return this.producer;
    }

    /**
     * 对象在⽤之前必须要调⽤⼀次，只能初始化⼀次
     */
    private void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * ⼀般在应⽤上下⽂，使⽤上下⽂监听器，进⾏关闭
     */
    public void shutdown() {
        this.producer.shutdown();
    }
}
