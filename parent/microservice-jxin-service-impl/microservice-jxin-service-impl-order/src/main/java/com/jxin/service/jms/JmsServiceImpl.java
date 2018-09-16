package com.jxin.service.jms;

import com.jxin.service.api.JmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Repository;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * @author:蔡佳新
 * @date:创建时间 22:58 2018/9/16
 * @note:
 */
@Repository
public class JmsServiceImpl implements JmsService {
    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;
    //用来发送消息到broker的对象
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    //发送消息，destination是发送到的队列，message是待发送的消息

    @Override
    public void sendMessage(Destination destination, final String message) {
        jmsTemplate.convertAndSend(destination, message);
    }


    //发送消息，destination是发送到的队列，message是待发送的消息
    @Override
    public void sendMessage(final String message) {
        jmsTemplate.convertAndSend(this.queue,message);

    }


    //=======发布订阅相关代码=========
    @Override
    public void publish(String msg) {
        this.jmsTemplate.convertAndSend(this.topic, msg);

    }
}
