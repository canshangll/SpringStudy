package com.lmj._01hello;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @projectName: RabbitMQDemo1
 * @package: com.lmj._01hello
 * @className: Producer
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/24 17:18
 * @version: 1.0
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //1、创建消息生产者
        DefaultMQProducer producer = new DefaultMQProducer("helloProducerGroup");
        //2、关联NameServer地址
        producer.setNamesrvAddr("localhost:9876");
        //3、连接NameServer（从NameServer拉去地址并且和Broker建立）
        producer.start();
        //4、消息目的地，主题Topic
        String topic = "helloTopic";
        //5、封装消息
        Message msg = new Message(topic, ("异步线程").getBytes());
        //6、发送消息
        System.out.println("发送消息前，处理线程："+Thread.currentThread());
        producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送的结果："+sendResult.getSendStatus());
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("消息发送异常");
            }
        });
        System.out.println("发送消息后，处理的线程："+Thread.currentThread());
        TimeUnit.SECONDS.sleep(5);
        //释放资源
        producer.shutdown();
    }
}
