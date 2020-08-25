package com.zhenhunfan.itoken.service.sso.controller;

import com.zhenhunfan.itoken.common.domain.TbSysUser;
import com.zhenhunfan.itoken.common.utils.CookieUtils;
import com.zhenhunfan.itoken.common.utils.MapperUtils;
import com.zhenhunfan.itoken.common.web.constants.WebConstants;
import com.zhenhunfan.itoken.service.sso.service.LoginService;
import com.zhenhunfan.itoken.service.sso.service.consumer.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
@Controller
public class LoginController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private LoginService loginService;

    /**
     * 跳转登录页
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(
            @RequestParam(required = false) String url,
            HttpServletRequest request, Model model) {
        String token = CookieUtils.getCookieValue(request, WebConstants.SESSION_TOKEN);

        // token 不为空可能已登录
        if (StringUtils.isNotBlank(token)) {
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)) {
                String json = redisService.get(loginCode);
                if (StringUtils.isNotBlank(json)) {
                    try {
                        TbSysUser tbSysUser = MapperUtils.json2pojo(json, TbSysUser.class);
                        // 已登录
                        if (tbSysUser != null) {
                            if (StringUtils.isNotBlank(url)) {
                                return "redirect:" + url;
                            }
                        }

                        // 将登录信息传到登录页
                        model.addAttribute(WebConstants.SESSION_USER, tbSysUser);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (StringUtils.isNotBlank(url)) {
            model.addAttribute("url", url);
        }

        return "login";
    }

    /**
     * 登录业务
     * @param loginCode
     * @param password
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String loginCode,
                        String password,
                        @RequestParam(required = false) String url,
                        HttpServletRequest request,
                        HttpServletResponse response){
        TbSysUser tbSysUser = loginService.login(loginCode, password);

        //登录成功
        if(tbSysUser!=null) {
            String token = UUID.randomUUID().toString();
            String result = redisService.put(token, loginCode, (long) (60 * 60 * 24));

            if ("ok".equals(result)) {
                CookieUtils.setCookie(request, response, WebConstants.SESSION_TOKEN, token, 60 * 60 * 24);
                if (StringUtils.isNotBlank(url))
                    return "redirect:" + url;
            }

            //熔断处理
            else{

            }
        }
        //为了执行上面的login方法，不能post过去
        return "redirect:/login";
    }

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, @RequestParam(required = false) String url, Model model) {
        try {
            CookieUtils.deleteCookie(request, response, WebConstants.SESSION_TOKEN);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (StringUtils.isNotBlank(url)) {
            return "redirect:/login?url=" + url;
        } else {
            return "redirect:/login";
        }
    }
}
