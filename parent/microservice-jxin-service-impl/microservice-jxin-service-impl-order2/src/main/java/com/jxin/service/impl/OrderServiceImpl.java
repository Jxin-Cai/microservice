package com.jxin.service.impl;

import com.jxin.service.feign.MemberServiceFeign;
import com.jxin.service.utils.ProblemUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

/**
 * @author:蔡佳新
 * @date:创建时间 10:03 2018/9/7
 * @note:
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderServiceImpl  {
    // 订单服务继承会员服务接口，用来实现feign客户端 减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @GetMapping(value = "/orderToMember",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem orderToMember(String name) {
        //用来判断是否有线程池隔离
        log.error("orderToMember:" + "线程池名称:" + Thread.currentThread().getName());
        return  memberServiceFeign.getMember(name);
    }

    // 没有解决服务雪崩效应
    @GetMapping(value = "/getSleepAPI01",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getSleepAPI01() {
        log.error("getSleepAPI01:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeign.getSleepAPI();
    }
    // Hystrix 有两种方式配置保护服务 通过注解和接口形式,明显注解好用
    // 解决服务雪崩效应
    // fallbackMethod 方法的作用：服务降级执行方法的指定
    // @HystrixCommand 默认开启线程池隔离方式,服务降级（包括活动线程占满降级和超时降级，超时降级默认1S）,服务熔断
    // 测试时需要设置Hystrix服务超时时间
    //如果注解配置了回调方法，优先走回调方法
    @HystrixCommand(fallbackMethod = "getSleepAPI02HystrixFallback")
    @RequestMapping("/getSleepAPI02")
    public Problem getSleepAPI02() {
        //用来判断是否有线程池隔离
        log.error("getSleepAPI02:" + "线程池名称:" + Thread.currentThread().getName());

        return memberServiceFeign.getSleepAPI();
    }
    //如果没配置@HystrixCommand，那么久没有线程池隔离
    @RequestMapping("/getSleepAPI03")
    public Problem getSleepAPI03() {
        //用来判断是否有线程池隔离
        log.error("getSleepAPI02:" + "线程池名称:" + Thread.currentThread().getName());
        return memberServiceFeign.getSleepAPI();
    }

    private Problem getSleepAPI02HystrixFallback() {
        return ProblemUtil.createProblem("高峰走服务降级");
    }




}
