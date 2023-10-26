package com.lmj._02tagfilter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.Date;

/**
 * @projectName: Rocketmq
 * @package: com.lmj._02tagfilter
 * @className: Producer
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/25 15:34
 * @version: 1.0
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        //1、创建消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("helloProducerGroup");
        //2、关联NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        //3、连接NameServer（从NameServer拉去地址并且和Broker建立）
        producer.start();
        //4、消息目的地，主题Topic
        String topic = "tagFilterTopic";
        //5、封装消息 //6、发送消息
        Message msg1 = new Message(topic,"TagA",("消息A").getBytes());
        producer.sendOneway(msg1);
        Message msg2 = new Message(topic,"TagB",("消息B").getBytes());
        producer.sendOneway(msg2);
        Message msg3 = new Message(topic,"TagC",("消息C").getBytes());
        producer.sendOneway(msg3);
        System.out.println("消息发送完毕");
        //释放资源
        producer.shutdown();
    }
}
