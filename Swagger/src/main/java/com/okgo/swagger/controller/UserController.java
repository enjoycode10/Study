package com.okgo.swagger.controller;

import com.okgo.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/6 13:59
 * @title Function
 */
@Api(value = "用户模块", produces = "User Module", consumes = "web font", tags = "user controller tags")
@RestController
public class UserController {
    // 模拟数据库数据
    public static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Alice", "passwd123"));
        users.add(new User(2, "Pony", "code333"));
    }

    @ApiOperation(value = "获取用户别表", notes = "获取所有用户的信息")
    @GetMapping("/swagger/users")
    public Object getAllUsers() {
        HashMap<String, List<User>> map = new HashMap<>();
        map.put("users", users);
        return users;
    }

    @ApiOperation(value = "根据用户ID查询用户", notes = "查询单个用户的信息")
    @ApiImplicitParam(name = "id", value = "用户ID", dataType = "int", paramType = "path")
    @GetMapping("/swagger/users/{id}")
    public Object getUserById(@PathVariable("id") int id) {
        return users.get(id) == null ? "***该用户不存在***" : users.get(id);
    }

    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(value = "用户类")
    @PostMapping("/swagger/user")
    public Object add(User user) {
        System.out.println(user);
        return users.add(user);
    }

    @ApiOperation(value = "删除用户", notes = "根据url的id来指定删除对象")
    @DeleteMapping(value = "/swagger/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        users.remove(id);
    }
}
