package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/4/6 18:02
 * @title Function
 */
public interface UserDao {


    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUserByAnnotation(User user);

    @Update("update user set name = #{name},pwd = #{password} where id = #{id}")
    int updateUserByAnnotation(User user);

    @Delete("delete from user where id = #{uid}")
    int deleteUserByAnnotation(@Param("uid") int id);

    //方法存在多个参数，所有的参数前面必须加上@Param注解
    @Select("select * from user_info where id = #{id}")
    User getUserByIdAnnotation(@Param("id") int id);

    @Select("select * from user_info")
    List<User> getUsers();

    // 分页查询
    List<User> getUserByLimit(Map<String, Integer> map);

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
