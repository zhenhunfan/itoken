package com.zhenhunfan.itoken.web.posts.service;

import com.zhenhunfan.itoken.web.posts.service.fallback.RedisServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>Title: RedisService</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/18
 */
@FeignClient(value = "itoken-service-redis",fallback = RedisServiceFallback.class)
public interface RedisService {
    @RequestMapping(value = "put",method = RequestMethod.POST)
    public String put(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value, @RequestParam(value = "seconds") Long seconds);

    @RequestMapping(value="get",method = RequestMethod.GET)
    public String get(@RequestParam(value = "key") String key);
}
