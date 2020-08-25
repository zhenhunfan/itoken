package com.zhenhunfan.itoken.web.admin.config;

import com.zhenhunfan.itoken.web.admin.interceptor.WebAdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: WebAdminInterceptorConfig</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/19
 */
@Configuration
public class WebAdminInterceptorConfig implements WebMvcConfigurer {

    @Bean
    WebAdminInterceptor webAdminInterceptor(){
        return new WebAdminInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(webAdminInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static");
    }
}
