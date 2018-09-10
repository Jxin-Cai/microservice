package com.jxin.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class Center01Application {

    public static void main(String[] args) {
        SpringApplication.run(CenterApplication.class, args);
    }
}
