package com.jxin.service.impl;

import com.jxin.service.feign.MemberServiceFeign;
import com.jxin.service.utils.ProblemUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zalando.problem.Problem;

import java.util.List;

/**
 * @author:蔡佳新
 * @date:创建时间 10:03 2018/9/7
 * @note:
 */
@RestController
@RequestMapping("/order2")
@Slf4j
public class Order2ServiceImpl {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    // springcloud 中使用那些技术实现调用服务接口 feign 或者rest
    @GetMapping("/orderToMember")
    public String orderToMember() {
        String memberUrl = "http://api-jxin-member/getMember";
        return restTemplate.getForObject(memberUrl, String.class);
    }

    @GetMapping("/discoveryClientMember")
    public List<ServiceInstance> discoveryClientMember() {
        List<ServiceInstance> instances = discoveryClient.getInstances("api-jxin-member");
        for (ServiceInstance serviceInstance : instances) {
            log.error("url:" + serviceInstance.getUri());
        }
        return instances;

    }




}
