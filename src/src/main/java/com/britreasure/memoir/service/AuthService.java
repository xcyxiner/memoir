package com.britreasure.memoir.service;

import com.britreasure.memoir.model.User;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午2:05
 */
public interface AuthService {
    public User register(User userAdd);

    public String login(String username, String password);

    public String refresh(String oldToken);
}
