package com.zhenhunfan.itoken.service.rabbit.service;

public interface RedisService {
    public void put(String key,Object value,long seconds);

    public Object get(String key);
}
