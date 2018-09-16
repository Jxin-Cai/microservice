package com.jxin.service.impl.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author:蔡佳新
 * @date:创建时间 23:10 2018/9/16
 * @note:
 */
@Component
@Slf4j
public class DoubleJms {
    @JmsListener(destination="jxin.double.topic", containerFactory="jmsListenerContainerTopic")
    public void receive1(String text){
        log.error("jxin.double.topic 消息广播消费者:receive1="+text+"=========="+Thread.currentThread().getName());
    }


    @JmsListener(destination="jxin.double.topic", containerFactory="jmsListenerContainerTopic")
    public void receive2(String text){
        log.error("jxin.double.topic 消息广播消费者:receive2="+text+"=========="+Thread.currentThread().getName());
    }


    @JmsListener(destination="jxin.double.topic", containerFactory="jmsListenerContainerTopic")
    public void receive3(String text){
        log.error("jxin.double.topic 消息广播消费者:receive3="+text+"=========="+Thread.currentThread().getName());
    }
}
