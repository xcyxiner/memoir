package com.britreasure.memoir.model;

/**
 * @author xcyxiner
 * @create: 2018-10-11 下午6:19
 */
public class JwtAuthenticationResponse {

    public String getToken() {
        return token;
    }
    
    private String token;

    public JwtAuthenticationResponse() {

    }

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }
}
