package com.britreasure.memoir;


import org.springframework.data.annotation.Id;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午6:05
 */
public class User {

    @Id
    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public User(Long id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }
}
