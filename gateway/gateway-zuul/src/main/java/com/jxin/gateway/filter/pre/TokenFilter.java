package com.jxin.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:蔡佳新
 * @date:创建时间 9:41 2018/9/12
 * @note:
 */
@Component
public class TokenFilter extends ZuulFilter {
/**    pre：可以在请求被路由之前调用
 *     routing： 路由请求时被调用
 *     post：在routing和error过滤器之后被调用
 *           处理请求时发生错误时被调用
 */
    @Override
    public String filterType() {
        return "pre";
    }
     /**
      * 过滤器执行顺序,通过int值来定义过滤器的执行顺序，数值越小优先级越高。
      */
    @Override
    public int filterOrder() {
        return 0;
    }
   /**
    *  返回一个boolean值来判断该过滤器是否要执行。我们可以通过此方法来指定过滤器的有效范围。
    */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * @Note: 过滤器拦截业务逻辑代码
     * @Paran:
     * @Return:
     * @Author:蔡佳新
     * @date:创建时间 9:42 2018/9/12
     */
    @Override
    public Object run(){
        // 案例：拦截所有的服务接口，判断服务接口上是否有传递userToken参数

        // 1.获取上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2.获取 Request
        HttpServletRequest request = currentContext.getRequest();
        // 3.获取token 的时候 从请求中获取,正式应该从请求头中获取
        String userToken = request.getParameter("userToken");
        //实际中应该拿这个userToken去调用会员服务的接口，确认是否是可用的userToken，如果是再放行，同时删除userToken
        if (StringUtils.isEmpty(userToken)) {
            // 不会继续执行... 不会去调用服务接口，网关服务直接响应给客户端
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseBody("userToken is null");
            currentContext.setResponseStatusCode(401);
            // 返回一个错误提示
        }
        // 正常执行调用其他服务接口...
        return null;
    }
}
