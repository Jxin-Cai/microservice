package com.jxin.service.feign;

import com.jxin.service.api.MemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author:蔡佳新
 * @date:创建时间 17:13 2018/9/7
 * @note:
 */
@FeignClient("app-jxin-member")
public interface MemberServiceFeign extends MemberService {
}
