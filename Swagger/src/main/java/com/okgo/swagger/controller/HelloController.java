package com.okgo.swagger.controller;

import com.okgo.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Shawn
 * @date 2020/4/5 0:20
 * @title Function
 */
@RestController
@Api(tags = "Hello 控制器上的@Api tags")
public class HelloController {
    @GetMapping("/swagger/hello")
    public String hello() {
        return "hello world!";
    }

    // 只要接口的返回值中存在实体类，实体类对应的model就会被swagger扫描到
    @PostMapping("/swagger/userInfo")
    public User getUser() {
        return new User(1, "name", "passcode");
    }

    @PostMapping("/swagger/say")
    @ApiOperation("From HelloController")
    public String say(@ApiParam("welcome") User user) {
        return "Welcome, " + user.getUsername() + ", you are a pretty good man!";
    }
}
