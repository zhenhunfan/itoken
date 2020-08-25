package com.zhenhunfan.itoken.web.admin.service.fallback;

import com.zhenhunfan.itoken.common.hystrix.Fallback;
import com.zhenhunfan.itoken.web.admin.service.RedisService;
import org.springframework.stereotype.Component;

/**
 * <p>Title: RedisServiceFallback</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
@Component
public class RedisServiceFallback implements RedisService {
    @Override
    public String put(String key, String value, Long seconds) {
        return Fallback.badGateway();
    }

    @Override
    public String get(String key) {
        return Fallback.badGateway();
    }
}
