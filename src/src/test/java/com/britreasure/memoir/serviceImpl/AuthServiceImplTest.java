package com.britreasure.memoir.serviceImpl;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午4:51
 */
public class AuthServiceImplTest extends JunitBaseTest {
    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void registerTest() {
        User findAdd = userRepository.findByUsername("hello");
        if (findAdd != null) {
            userRepository.delete(findAdd);
        }
        User newUser = new User("hello", "593091948@qq.com", "123456");
        User useradd = authService.register(newUser);
        Assert.assertNotNull(useradd);
        User userTwo = authService.register(newUser);
        Assert.assertNull(userTwo);
    }

    @Test
    public void loginTest() {
        User findAdd = userRepository.findByUsername("hello");
        if (findAdd != null) {
            userRepository.delete(findAdd);
        }
        String username = "hello";
        String password = "123456";
        User newUser = new User(username, "593091948@qq.com", password);
        User useradd = authService.register(newUser);
        Assert.assertNotNull(useradd);
        String token = authService.login(username, password);
        Assert.assertNotNull(token);

    }
}
