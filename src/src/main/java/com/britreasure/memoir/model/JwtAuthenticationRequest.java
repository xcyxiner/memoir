package com.britreasure.memoir.model;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午6:17
 */
public class JwtAuthenticationRequest {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public JwtAuthenticationRequest() {
        
    }
}
