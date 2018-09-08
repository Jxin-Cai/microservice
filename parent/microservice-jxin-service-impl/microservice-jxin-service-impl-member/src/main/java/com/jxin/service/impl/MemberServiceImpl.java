package com.jxin.service.impl;


import com.jxin.service.api.MemberService;
import com.jxin.service.entity.User;
import com.jxin.service.utils.ProblemUtil;
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
public class MemberServiceImpl implements MemberService {
    @GetMapping(value = "/getMember",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem getMember(String name) {

        return ProblemUtil.createProblem(User.builder()
                                            .name(name)
                                            .age(9)
                                            .phone("123456789")
                                            .build());
    }
}
