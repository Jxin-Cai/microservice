package com.jxin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author:蔡佳新
 * @date:创建时间 16:49 2018/9/7
 * @note:
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class OrderApplication {
    public static void main(String[] args) { SpringApplication.run(OrderApplication.class, args); }
}
