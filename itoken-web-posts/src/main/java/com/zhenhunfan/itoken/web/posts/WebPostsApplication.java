package com.zhenhunfan.itoken.web.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <p>Title: WebPostsApplication</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/21
 */
@SpringBootApplication(scanBasePackages = "com.zhenhunfan.itoken")
@EnableDiscoveryClient
@EnableFeignClients
public class WebPostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebPostsApplication.class,args);
    }
}
