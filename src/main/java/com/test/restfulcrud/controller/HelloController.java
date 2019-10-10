package com.test.restfulcrud.controller;

import com.test.restfulcrud.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    // 主页映射,默认会得到thymeleaf模板引擎的解析
    /*@RequestMapping({"/", "/index.html"})
    public String index() {
        return "index";
    }*/

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(String user) {
        if (user.equals("test")) {
            throw new UserNotExistException();
        } else {
            return "Hello World";
        }
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("userList", Arrays.asList("张三", "李四", "王五"));
        return "success";
    }
}

