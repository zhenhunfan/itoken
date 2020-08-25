package com.zhenhunfan.itoken.service.rabbit.controller;

import com.zhenhunfan.itoken.common.dto.BaseResult;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: RabbitMqController</p>
 * <p>Description: </p>
 *
 * @author zhenhunfan
 * @version 1.0.0
 * @date 2020/8/24
 */
@RestController
public class RabbitMqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping(value = "send",method = RequestMethod.POST)
    public BaseResult send(String message){
        amqpTemplate.convertAndSend("Quere_1",message);
        return BaseResult.ok();
    }
}
