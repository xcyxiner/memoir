package com.britreasure.memoir.controller;

import com.britreasure.memoir.model.RabbitmqMessage;
import com.britreasure.memoir.serviceImpl.HelloSender;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午4:21
 */
@RestController
@RequestMapping("/api/rabbitmq")
@Api("RabbitmqController controller")
public class RabbitmqController {

    @Autowired
    private HelloSender helloSender;


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "Send Msg to hello queue")
    @RequestMapping(value = "/sendMsg", method = RequestMethod.POST)
    public void sendHelloMsg(@RequestBody RabbitmqMessage rabbitmqMessage) {
        helloSender.send(rabbitmqMessage.getContent());
    }

    @ApiOperation(value = "get last send msg from hello queue")
    @RequestMapping(value = "/getLastMsg", method = RequestMethod.GET)
    public String getHelloMsg() {
        return stringRedisTemplate.opsForValue().get("hello");
    }
}
