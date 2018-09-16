package com.jxin.service.api;

import javax.jms.Destination;

/**
 * @author:蔡佳新
 * @date:创建时间 22:42 2018/9/16
 * @note:
 */
public interface JmsService {
    /**
     * 功能描述：指定消息队列，还有消息
     * @param destination
     * @param message
     */
     void sendMessage(Destination destination, final String message);


    /**
     * 功能描述：使用默认消息队列， 发送消息
     * @param message
     */
     void sendMessage( final String message);


    /**
     * 功能描述：消息发布者
     * @param msg
     */
     void publish(String msg);

}
