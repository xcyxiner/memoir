package com.britreasure.memoir.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午4:14
 */
@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}
