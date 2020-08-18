package com.okgo.jwt.controller;

import com.okgo.jwt.annotation.TokenRequired;
import com.okgo.jwt.entity.User;
import com.okgo.jwt.result.ResultDTO;
import com.okgo.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/7/5 2:52
 * @title Function
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     *
     * @return
     */
    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResultDTO<Map<String, String>> login(@RequestBody User user) {
//        User user = new User("1", "shawn", "123456");
        String token = userService.login(user.getUsername(), user.getPassword());
        /*if (token == null) {
            return ResultDTO.failure(new ResultError(UserError.PASSWORD_OR_NAME_IS_ERROR));
        }*/
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return ResultDTO.success(tokenMap);
    }

    @TokenRequired
    @GetMapping(value = "/hello")
    public String getMessage() {
        return "你好哇，我是小码仔";
    }
}
