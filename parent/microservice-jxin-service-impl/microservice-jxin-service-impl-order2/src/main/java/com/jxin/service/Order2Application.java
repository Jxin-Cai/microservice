package com.jxin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author:蔡佳新
 * @date:创建时间 16:49 2018/9/7
 * @note:
 */

@EnableHystrix
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class Order2Application {
    public static void main(String[] args) { SpringApplication.run(Order2Application.class, args); }


    // 默认rest方式开启 负载均衡功能 如果以app-itmayiedu-member名称进行调用服务接口的时候 必须
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
