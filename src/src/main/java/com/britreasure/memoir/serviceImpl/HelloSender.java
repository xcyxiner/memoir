package com.britreasure.memoir.serviceImpl;

import com.britreasure.memoir.config.RedisConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午3:58
 */
@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final Logger lg = LoggerFactory.getLogger(RedisConfiguration.class);

    public void send(String msg) {
        if (msg == null) {
            msg = "hello " + new Date();
        }
        lg.info("rabbitmq send msg", msg);
        this.amqpTemplate.convertAndSend("hello", msg);
    }
}
