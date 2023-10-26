package com.lmj._03sqlfilter;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;

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
        String topic = "sqlFilterTopic";
        //5、封装消息 //6、发送消息
        Message msg1 = new Message(topic,("美女A").getBytes());
        msg1.putUserProperty("age","18");
        msg1.putUserProperty("weight","50");
        producer.sendOneway(msg1);
        Message msg2 = new Message(topic,("美女B").getBytes());
        msg2.putUserProperty("age","28");
        msg2.putUserProperty("weight","60");
        producer.sendOneway(msg2);
        Message msg3 = new Message(topic,("美女C").getBytes());
        msg3.putUserProperty("age","68");
        msg3.putUserProperty("weight","80");
        producer.sendOneway(msg3);
        System.out.println("消息发送完毕");
        //释放资源
        producer.shutdown();
    }
}
