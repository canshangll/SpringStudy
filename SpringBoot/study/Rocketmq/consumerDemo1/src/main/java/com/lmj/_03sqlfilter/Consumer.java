package com.lmj._03sqlfilter;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.Date;
import java.util.List;

/**
 * @projectName: Rocketmq
 * @package: com.lmj._01hello
 * @className: Consumer
 * @author: lmj
 * @description: TODO
 * @date: 2023/10/24 18:22
 * @version: 1.0
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //1.定义消息消费者
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("helloConsumerGroup");
        //2.设置NameServer的地址
        consumer.setNamesrvAddr("localhost:9876");
        //3.设置监听的主题
        consumer.subscribe("sqlFilterTopic", MessageSelector.bySql("age >20 and weight > 70"));
        //4.设置消息的监听器
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msgExt:list){
                    //业务逻辑
                    System.out.println("消息内容："+new String(msgExt.getBody())+"消息消费的时间：" + new Date());
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.建立连接
        consumer.start();
    }
}
