package com.zhenhunfan.itoken.service.quartz.demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: PrintCurrentTime</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/25
 */
@Component
public class PrintCurrentTime {
    /**
     * 每5秒打印一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void print(){
        System.out.println("Current Time is:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
