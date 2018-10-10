package com.britreasure.memoir.repository;

import com.britreasure.memoir.JunitBaseTest;
import com.britreasure.memoir.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午6:28
 */
public class UserRepositoryTestJunit extends JunitBaseTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testAddUser() {
        userRepository.save(new User("xcyxiner", 30));
        Assert.assertSame(30, userRepository.findByUsername("xcyxiner").getAge());
    }
}
