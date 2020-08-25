package com.zhenhunfan.itoken.service.posts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * <p>Title: ServicePostsApplication</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/20
 */
@SpringBootApplication(scanBasePackages = {"com.zhenhunfan.itoken.common.context","com.zhenhunfan.itoken.service.posts"})
@EnableEurekaClient
@MapperScan(basePackages = {"com.zhenhunfan.itoken.service.posts.mapper","com.zhenhunfan.itoken.common.mapper"})
@EnableSwagger2
public class ServicePostsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServicePostsApplication.class,args);
    }
}