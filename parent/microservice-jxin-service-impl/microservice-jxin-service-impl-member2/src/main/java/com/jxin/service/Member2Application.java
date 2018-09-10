package com.jxin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author:蔡佳新
 * @date:创建时间 16:46 2018/9/7
 * @note:
 */
@EnableEurekaClient
@SpringBootApplication
public class Member2Application {
    public static void main(String[] args) { SpringApplication.run(Member2Application.class, args); }
}
