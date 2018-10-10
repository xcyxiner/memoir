package com.britreasure.memoir.service;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.serviceImpl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author xcyxiner
 * @create: 2018-10-10 上午11:09
 */
public class UserServiceImplTestJunit extends JunitBaseTest {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void findAllTest() {
        List<User> list = userServiceImpl.findAll();
        Assert.assertNotNull(list.get(0).getUsername());
        Assert.assertEquals("value is xcyxiner", "xcyxiner", stringRedisTemplate.opsForValue().get("user:name"));
    }
}
