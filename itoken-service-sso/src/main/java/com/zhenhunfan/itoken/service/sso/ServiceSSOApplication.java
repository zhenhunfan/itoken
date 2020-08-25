package com.zhenhunfan.itoken.service.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = "com.zhenhunfan.itoken") //为了能够扫描到所有的@Configuration
@EnableEurekaClient     //服务提供者
@EnableDiscoveryClient  //服务消费者
@EnableFeignClients     //是feign消费者
@MapperScan(basePackages = "com.zhenhunfan.itoken.service.sso.mapper")
public class ServiceSSOApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSSOApplication.class,args);
    }
}
