package com.jxin.service.impl;

import com.jxin.service.api.JmsService;
import com.jxin.service.utils.ProblemUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

import javax.jms.Destination;

/**
 * @author:蔡佳新
 * @date:创建时间 23:13 2018/9/16
 * @note:
 */
@RestController
@Slf4j
public class SendJmsServiceImpl {
    @Autowired
    JmsService jmsService;

    @GetMapping("/only")
    public Problem only(@RequestParam("msg") String msg){

        Destination destination = new ActiveMQQueue("jxin.only.queue");

        jmsService.sendMessage(destination, msg);

        return ProblemUtil.createProblem("success");
    }

    @GetMapping("/common")
    public Problem common(@RequestParam("msg")String msg){
        jmsService.sendMessage(msg);
        return  ProblemUtil.createProblem("success");
    }
    @GetMapping("/doubleJms")
    public Problem doubleJms(@RequestParam("msg")String msg){
        jmsService.publish(msg);
        return  ProblemUtil.createProblem("success");
    }
}
