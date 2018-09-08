package com.jxin.service.impl;

import com.jxin.service.feign.MemberServiceFeign;
import com.jxin.service.utils.ProblemUtil;
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
public class OrderServiceImpl  {
    // 订单服务继承会员服务接口，用来实现feign客户端 减少重复接口代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @GetMapping(value = "/orderToMember",produces = MediaType.APPLICATION_JSON_VALUE)
    public Problem orderToMember(String name) {
        return  memberServiceFeign.getMember(name);
    }

}
