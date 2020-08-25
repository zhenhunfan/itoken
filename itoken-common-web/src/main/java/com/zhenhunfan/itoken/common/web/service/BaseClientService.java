package com.zhenhunfan.itoken.common.web.service;

import com.zhenhunfan.itoken.common.hystrix.Fallback;

/**
 * <p>Title: BaseClientService</p>
 * <p>Description: 通用服务消费者接口</p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/21
 */
public interface BaseClientService {
    default String page(int pageNum, int pageSize, String domainJson) {
        return Fallback.badGateway();
    }
}
