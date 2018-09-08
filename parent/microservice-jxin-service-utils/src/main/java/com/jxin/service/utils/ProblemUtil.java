package com.jxin.service.utils;

import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;

import java.util.List;

/**
 * @author:蔡佳新
 * @date:创建时间 0:58 2018/6/24
 * @note:封装problem的创建，利用重载的方法实现多参数创建实例对象
 */
public class ProblemUtil {

    public static Problem createProblem(Object... datas) {

        ProblemBuilder builder = Problem.builder().withDetail("success").with("code", 0);
        for (Object obj : datas) {
            String name = getName(obj);
            builder.with(name, obj);
        }
        return builder.build();
    }

    public static Problem createProblem(String detail, Object... datas) {
        ProblemBuilder builder = Problem.builder().withDetail(detail).with("code", 0);
        for (Object obj : datas) {
            String name = getName(obj);
            builder.with(name, obj);
        }
        return builder.build();
    }

    public static Problem createProblem(String detail, int code, Object... datas) {
        ProblemBuilder builder = Problem.builder().withDetail(detail).with("code", code);
        for (Object obj : datas) {
            String name = getName(obj);
            builder.with(name, obj);
        }
        return builder.build();
    }

    private static String getName(Object obj) {
        String name = null;
        if (obj instanceof List) {
            name = ((List) obj).get(0).getClass().getName() + "s";

        } else {
            name = obj.getClass().getName();
        }
        return tolowFirstCase(name.substring(name.lastIndexOf(".") + 1));
    }

    private static String tolowFirstCase(String str) {
        char[] c = str.toCharArray();
        c[0] = (char) (c[0] - (32)); //ASCII
        return c.toString();
    }

}
