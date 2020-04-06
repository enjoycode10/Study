package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/4/6 18:02
 * @title Function
 */
public interface UserDao {
    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //万能Map
    int addUser2(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    //删除一个用户
    int deleteUser(int id);
}
