package com.jxin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author:蔡佳新
 * @date:创建时间 16:49 2018/9/7
 * @note:
 */
@EnableHystrix
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableJms
public class OrderApplication {
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("jxin.double.topic");
    }


    /**
     * @Note: 将队列交给spring管理
     * @Paran:
     * @Return:
     * @Author:蔡佳新
     * @date:创建时间 22:41 2018/9/16
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("jxin.only.queue");
    }
    public static void main(String[] args) { SpringApplication.run(OrderApplication.class, args); }
}
