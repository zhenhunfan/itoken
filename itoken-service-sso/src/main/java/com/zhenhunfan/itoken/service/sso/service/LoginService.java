package com.zhenhunfan.itoken.service.sso.service;

import com.zhenhunfan.itoken.common.domain.TbSysUser;

/**
 * <p>Title: LoginService</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
public interface LoginService {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public TbSysUser login(String loginCode,String plantPassword);
}
