package com.britreasure.memoir.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xcyxiner
 * @create: 2018-10-10 上午11:03
 */
@Service
public class UserServiceImpl {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    public List<User> findAll() {
        List<User> list = userRepository.findAll();
        redisTemplate.opsForList().leftPush("user:list", JSON.toJSONString(list));
        stringRedisTemplate.opsForValue().set("user:name", "xcyxiner");
        return list;
    }
}
