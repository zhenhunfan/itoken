package com.zhenhunfan.itoken.common.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Title: ConstantsInterceptor</p>
 * <p>Description: 初始化常量拦截器</p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/19
 */
public class ConstantsInterceptor implements HandlerInterceptor {

    private static final String HOST_CDN = "http://192.168.127.133:82";
    private static final String TEMPLATE_ADMIN_LTE = "";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null){ //如果是RestController，则该对象为空
            modelAndView.addObject("adminlte",HOST_CDN+TEMPLATE_ADMIN_LTE);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
