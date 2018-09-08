package com.jxin.service.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zalando.problem.Problem;

/**
 * @author:蔡佳新
 * @date:创建时间 0:42 2018/9/7
 * @note:
 */
public interface MemberService {

    // 实体类是存放接口项目还是存放在实现项目： 实体类存放在接口项目里面
    // @RequestParam必须添加

    @GetMapping("/getMember")
    Problem getMember(@RequestParam("name") String name);
}
