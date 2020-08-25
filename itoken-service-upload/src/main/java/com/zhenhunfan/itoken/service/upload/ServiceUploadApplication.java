package com.zhenhunfan.itoken.service.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <p>Title: ServiceUploadApplication</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/24
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUploadApplication.class,args);
    }
}
