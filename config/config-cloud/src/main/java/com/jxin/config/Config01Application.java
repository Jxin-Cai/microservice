package com.jxin.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author:蔡佳新
 * @date:创建时间 11:48 2018/9/12
 * @note:
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class } /* 忽略数据源加载 */)
@EnableConfigServer
@EnableEurekaClient
public class Config01Application {
    public static void main(String[] args) {
        SpringApplication.run(Config01Application.class, args);
    }
}
