package com.zhenhunfan.itoken.service.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Title: RabbitConsumer</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/24
 */
@Component
@RabbitListener(queues = "Quere_1")
public class RabbitConsumer {

    @RabbitHandler
    public void process(String message){
        System.out.println(message);
    }
}
