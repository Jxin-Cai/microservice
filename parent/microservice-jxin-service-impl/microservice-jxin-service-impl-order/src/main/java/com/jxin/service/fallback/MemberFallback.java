package com.jxin.service.fallback;

import com.jxin.service.feign.MemberServiceFeign;
import com.jxin.service.utils.ProblemUtil;
import org.springframework.stereotype.Component;
import org.zalando.problem.Problem;

/**
 * @author:蔡佳新
 * @date:创建时间 23:30 2018/9/11
 * @note:
 */
@Component
public class MemberFallback implements MemberServiceFeign {
    @Override
    public Problem getMember(String name) {
        return null;
    }

    @Override
    public Problem getSleepAPI() {
        return ProblemUtil.createProblem("error",404,"类实现");
    }
}
