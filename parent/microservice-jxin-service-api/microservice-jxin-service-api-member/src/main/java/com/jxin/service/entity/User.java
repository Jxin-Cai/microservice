package com.jxin.service.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author:蔡佳新
 * @date:创建时间 0:42 2018/9/7
 * @note:
 */
@Data
@Builder
public class User {
    private String name;
    private int age;
    private String phone;
}
