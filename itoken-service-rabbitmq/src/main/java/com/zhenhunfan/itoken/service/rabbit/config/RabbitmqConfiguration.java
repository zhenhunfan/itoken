package com.zhenhunfan.itoken.service.rabbit.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Title: RabbitmqConfiguration</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/24
 */
@Configuration
public class RabbitmqConfiguration {
    @Bean
    public Queue queue(){
        return new Queue("Quere_1");
    }
}
