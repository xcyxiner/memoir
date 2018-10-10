package com.britreasure.memoir.controller;


import com.britreasure.memoir.config.StudentProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcyxiner
 * @create: 2018-10-09 下午3:58
 */
@RestController
@RequestMapping("api")
@Api("HelloController API")
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @Value("${name}")
    private String name;

    @ApiOperation(value = "获取hello输出", notes = "hello world")
    @ApiResponse(code = 200, message = "hello world!")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world!" + name + "--" + studentProperties.getName();
    }

    @ApiOperation(value = "输出name", notes = "如果name为空则输出默认")
    @ApiImplicitParam(name = "namevalue", value = "name vlue", paramType = "path", dataType = "String")
    @RequestMapping(value = "/name/{namevalue}", method = RequestMethod.GET)
    public String GetName(@PathVariable String namevalue) {

        if (namevalue != null) {
            return namevalue;
        }
        return this.name;
    }

}
