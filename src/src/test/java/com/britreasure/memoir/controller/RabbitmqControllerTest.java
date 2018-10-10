package com.britreasure.memoir.controller;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.RabbitmqMessage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-10 下午5:17
 */
public class RabbitmqControllerTest extends JunitBaseTest {
    @Autowired
    private RabbitmqController rabbitmqController;


    @Test
    public void getHelloMsgTest() {
        String sendContent = "test20181010";
        rabbitmqController.sendHelloMsg(new RabbitmqMessage(sendContent));
        Assert.assertEquals("send Content is equal", sendContent, rabbitmqController.getHelloMsg());
    }
}
