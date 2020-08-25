package com.zhenhunfan.itoken.service.rabbit.controller;

import com.zhenhunfan.itoken.service.rabbit.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put",method = RequestMethod.POST)
    public String put(String key,String value,long seconds){
        redisService.put(key,value,seconds);
        return "ok";
    }

    @RequestMapping(value="get",method = RequestMethod.GET)
    public String get(String key){
        Object o = redisService.get(key);
        if(o!=null){
            return String.valueOf(o);
        }
        return null;
    }
}
