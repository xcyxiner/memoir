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
public class IUserRepositoryTestJunit extends JunitBaseTest {
    @Autowired
    private IUserRepository userRepository;

    @Test
    public void testAddUser() {
        userRepository.save(new User(1L, "xcyxiner", 30));
        Assert.assertSame(30, userRepository.findByUsername("xcyxiner").getAge());
    }
}
