package com.jxin.service.impl;


import com.jxin.service.api.MemberService;
import com.jxin.service.entity.User;
import com.jxin.service.utils.ProblemUtil;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.problem.Problem;

/**
 * @author:蔡佳新
 * @date:创建时间 9:20 2018/9/7
 * @note:
 */
@RestController
@Slf4j
public class MemberServiceImpl implements MemberService {
    //用于识别是哪个会员服务
    @Value("${server.port}")
    private String serverPort;

    @Override
    @GetMapping(value = "/getMember",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getMember(String name) {
           //int i = 1/0;
        return ProblemUtil.createProblem(User.builder()
                                            .name(name+"=="+serverPort)
                                            .age(9)
                                            .phone("123456789")
                                            .build());
    }
    @Override
    @GetMapping(value = "/getSleepAPI",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getSleepAPI() {
        System.out.println("开始休眠1.5秒");
        try {
            // 会员服务接口产生1.5秒的延迟
            Thread.sleep(1500);
        } catch (Exception e) {
            log.error("休眠发生异常");
        }
        return ProblemUtil.createProblem("成功调用休眠接口",200,"正常过");
    }
}
