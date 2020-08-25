package com.zhenhunfan.itoken.web.admin.interceptor;

import com.zhenhunfan.itoken.common.domain.TbSysUser;
import com.zhenhunfan.itoken.common.utils.CookieUtils;
import com.zhenhunfan.itoken.common.utils.MapperUtils;
import com.zhenhunfan.itoken.common.web.constants.WebConstants;
import com.zhenhunfan.itoken.common.web.interceptor.BaseInterceptorMethods;
import com.zhenhunfan.itoken.common.web.utils.HttpServletUtils;
import com.zhenhunfan.itoken.web.admin.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * <p>Title: WebAdminInterceptor</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/19
 */
public class WebAdminInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        return BaseInterceptorMethods.preHandleForLogin(request, response, handler, "http://localhost:8601/" + request.getServletPath());
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                BaseInterceptorMethods.postHandleForLogin(request, response, handler, modelAndView, redisService.get(loginCode), "http://localhost:8601/" + request.getServletPath());
            }
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
