package com.britreasure.memoir.utili;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.JwtAuthenticationResponse;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.util.BeanToMapUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午7:12
 */
public class BeanToMapUtilTest extends JunitBaseTest {

    @Test
    public void objectToMapTest() {
        JwtAuthenticationResponse jwtAuthenticationResponse = new JwtAuthenticationResponse("123123");
        User user = new User("hello", 20);
        Map<String, Object> map = BeanToMapUtil.objectToMap(user);
        Assert.assertNotNull(map);
        ObjectMapper objectMapper = new ObjectMapper();
        User tmpNew = objectMapper.convertValue(map, User.class);
        Assert.assertNotNull(tmpNew);
    }
}
