package com.britreasure.memoir.config;

import com.britreasure.memoir.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-10 上午9:50
 */
public class RedisConfigurationTest extends BaseTest {

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
