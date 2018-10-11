package com.britreasure.memoir.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.repository.UserRepository;
import com.britreasure.memoir.service.AuthService;
import com.britreasure.memoir.util.BeanToMapUtil;
import com.britreasure.memoir.util.JwtTokenUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static java.util.Arrays.asList;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午2:07
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public User register(User userAdd) {
        String userName = userAdd.getUsername();
        if (userRepository.findByUsername(userName) != null) {
            return null;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userAdd.getPassword();
        userAdd.setPassword(encoder.encode(rawPassword));
        userAdd.setRoles(asList("ROLE_USER"));
        return userRepository.insert(userAdd);
    }

    @Override
    public String login(String username, String password) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        JSON.toJSONString(userDetails);
        Map<String, Object> map = BeanToMapUtil.objectToMap(userDetails);
        final String token = jwtTokenUtil.generateToken(map);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        return null;
    }
}
