package com.lmj._01hello;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.protocol.heartbeat.MessageModel;

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
        consumer.subscribe("helloTopic","*");
        //设置消息消费的模式
        consumer.setMessageModel(MessageModel.BROADCASTING);
        //4.设置消息的监听器
        /**
         * ConsumeConcurrentlyStatus.RECONSUME_LATER; 告诉消息中间件，该消息正常消费完毕。消息不会再发送过来
         * ConsumeConcurrentlyStatus.CONSUME_SUCCESS; 此次的业务失败了，希望待会消息中间件重新发送消息给我
         */
        consumer.setMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msgExt:list){
                    //业务逻辑
                    System.out.println("当前线程："+Thread.currentThread()+"，消息内容："+new String(msgExt.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        //5.建立连接
        consumer.start();
    }
}
