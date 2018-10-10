package com.britreasure.memoir.controller;


import com.britreasure.memoir.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午3:58
 */
@RestController
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @Value("${name}")
    private String name;

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!" + name + "--" + studentProperties.getName();
    }

    @RequestMapping("/name")
    public String GetName() {
        return name;
    }

}
