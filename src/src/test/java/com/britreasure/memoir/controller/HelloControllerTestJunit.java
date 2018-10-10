package com.britreasure.memoir.controller;

import com.britreasure.memoir.JunitBaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午5:33
 */
public class HelloControllerTestJunit extends JunitBaseTest {
    @Autowired
    private HelloController helloController;

    @Test
    public void Testhello() {
        Assert.assertEquals("hello response error", "hello world!hellokitty--testkitty", helloController.hello());
    }
}
