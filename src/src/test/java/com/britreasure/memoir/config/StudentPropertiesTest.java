package com.britreasure.memoir.config;

import com.britreasure.memoir.BaseTest;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午5:24
 */
public class StudentPropertiesTest extends BaseTest {
    @Autowired
    private StudentProperties studentProperties;


    @Ignore("not ready yet")
    @Test
    public void testgetName() {
        Assert.assertEquals("name is error", "testkitty", studentProperties.getName());
    }

    @Test
    public void testgetAge() {
        Assert.assertSame("age is error", 30, studentProperties.getAge());
    }
}
