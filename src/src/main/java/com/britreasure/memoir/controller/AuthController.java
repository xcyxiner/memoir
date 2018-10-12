package com.britreasure.memoir.controller;

import com.britreasure.memoir.model.JwtAuthenticationRequest;
import com.britreasure.memoir.model.JwtAuthenticationResponse;
import com.britreasure.memoir.model.User;
import com.britreasure.memoir.service.AuthService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午2:10
 */
@RestController
@Api("AuthController API")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User addUser) throws AuthenticationException {
        return authService.register(addUser);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword()); // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

}


