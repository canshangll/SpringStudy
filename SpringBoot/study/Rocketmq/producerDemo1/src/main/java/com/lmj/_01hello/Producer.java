package com.lmj._01hello;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @projectName: RabbitMQDemo1
 * @package: com.lmj._01hello
 * @className: Producer
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/24 17:18
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
        String topic = "helloTopic";
        for (int i = 0; i < 10; i++) {
            //5、封装消息
            Message msg = new Message(topic,("hello消息"+i).getBytes());
            Thread.sleep(1000);
            //6、发送消息
            SendResult result = producer.send(msg);
            System.out.println("消息存储的结果："+result.getSendStatus());
        }
        //释放资源
        producer.shutdown();
    }
}
