package com.ffideal.springbootdemo.controller;

import com.ffideal.springbootdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: HelloController
 * @Description: TODO
 * @Author: ffideal
 * @Date: 2022/2/14 21:26
 * @Version: v1.0
 */

@RestController
public class HelloController {

    @Autowired
    User user;
    @RequestMapping("/hello")
    public String handle01(){
        return "Hello, Spring Boot 2!";
    }

    @RequestMapping("/testYaml")
    public User testYaml() {
        return user;
    }

    @RequestMapping("/001.png")
    public String staticResources() {
        return "002";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }


}
