package com.britreasure.memoir.service;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.serviceImpl.HelloSender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午4:09
 */
public class HelloSenderTest extends JunitBaseTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void sendTest() throws Exception {
        helloSender.send("hello world spring boot");
    }
}
