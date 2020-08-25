package com.zhenhunfan.itoken.common.web.config;

import com.zhenhunfan.itoken.common.web.interceptor.ConstantsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>Title: InterceptorConfig</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/19
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    public ConstantsInterceptor constantsInterceptor() {
        return new ConstantsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 常量拦截器
        registry.addInterceptor(constantsInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/static/**");
    }
}
