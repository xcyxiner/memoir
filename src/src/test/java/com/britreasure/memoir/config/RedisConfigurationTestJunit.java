package com.britreasure.memoir.config;

import com.britreasure.memoir.JunitBaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-10 上午9:50
 */
public class RedisConfigurationTestJunit extends JunitBaseTest {

    @Autowired
    private RedisConfiguration redisConfiguration;

    @Autowired


    @Test
    public void keyGeneratorTest() {
        Assert.assertNotNull(redisConfiguration.keyGenerator());
    }

    @Test
    public void cacheManagerTest() {
        Assert.assertNotNull(redisConfiguration.cacheManager());
    }


}
