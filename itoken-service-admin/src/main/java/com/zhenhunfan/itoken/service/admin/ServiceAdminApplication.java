package com.zhenhunfan.itoken.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {"com.zhenhunfan.itoken.common.context","com.zhenhunfan.itoken.service.admin"})
@EnableEurekaClient
@MapperScan(basePackages = {"com.zhenhunfan.itoken.service.admin.mapper","com.zhenhunfan.itoken.common.mapper"})
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class,args);
    }
}
