package com.jxin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author:蔡佳新
 * @date:创建时间 16:46 2018/9/7
 * @note:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Member3Application {
    public static void main(String[] args) { SpringApplication.run(Member3Application.class, args); }
}
