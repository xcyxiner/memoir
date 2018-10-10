package com.britreasure.memoir.serviceImpl;

import com.britreasure.memoir.config.RedisConfiguration;
import com.britreasure.memoir.model.RabbitmqLastMessage;
import com.britreasure.memoir.repository.RabbitmqLastMessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午4:03
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {

    private static final Logger lg = LoggerFactory.getLogger(RedisConfiguration.class);

    @Autowired
    private RabbitmqLastMessageRepository rabbitmqLastMessageRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RabbitHandler
    public void process(String helloContent) {
        stringRedisTemplate.opsForValue().set("hello", helloContent);
        rabbitmqLastMessageRepository.save(new RabbitmqLastMessage("hello", helloContent));
        lg.info("rabbitmq receive" + helloContent);
    }
}
