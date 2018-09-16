package com.jxin.service.impl.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author:蔡佳新
 * @date:创建时间 23:08 2018/9/16
 * @note:
 */
@Component
@Slf4j
public class OnlyJms {
    @JmsListener(destination="jxin.only.queue")
    public void receiveQueue(String text){
        log.error("单点消息收到的报文为:"+text);
    }
}
