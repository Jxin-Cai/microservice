package com.jxin.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * @author:蔡佳新
 * @date:创建时间 16:46 2018/9/7
 * @note:
 */
@EnableEurekaServer
@SpringBootApplication
public class Center02Application {

    public static void main(String[] args) {
        SpringApplication.run(Center02Application.class, args);
    }
}
