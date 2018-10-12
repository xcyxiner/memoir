package com.britreasure.memoir.utili;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.util.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午2:45
 */
public class JwtTokenUtilTest extends JunitBaseTest {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void generateTokenTest() {
        Assert.assertNotNull(jwtTokenUtil.generalKey());
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "xcyxiner");
        String tokenSign = jwtTokenUtil.generateToken(map);
        Assert.assertNotNull(tokenSign);
        Claims tmpObj = jwtTokenUtil.getClaimsFromToken(tokenSign);
        Assert.assertNotNull(tmpObj);
        Assert.assertEquals("xcyxiner", tmpObj.get("username"));
    }


    @Test
    public void validateTokenTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "xcyxiner");
        String tokenSign = jwtTokenUtil.generateToken(map);
        boolean checkResult = jwtTokenUtil.validateToken(tokenSign, map);
        Assert.assertTrue(checkResult);
    }
}
