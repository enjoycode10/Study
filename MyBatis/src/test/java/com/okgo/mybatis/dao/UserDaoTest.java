package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.User;
import com.okgo.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/6 18:14
 * @title Function
 */
public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    @Test
    public void testLog4j() {
        logger.info("info: ");
        logger.debug("info: ");
        logger.error("info: ");
        logger.trace("info: ");
        logger.fatal("info: ");
    }

    @Test
    public void testGetUserByIdAnnotation() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUserByIdAnnotation(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void testGetUsers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userByLimit = mapper.getUsers();
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void testGetUserByLimit() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);

        List<User> userByLimit = mapper.getUserByLimit(map);
        for (User user : userByLimit) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void test() {
        // 1. 获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            // 2. 方式一：执行sql - java接口
            /*UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> userList = mapper.getUserList();
            */

            // 2. 方式二：执行sql - 强转
            List<User> users = sqlSession.selectList("com.okgo.mybatis.dao.UserDao.getUserList");
            for (User user : users) {
                System.out.println(user);
            }

            // 2. 方式三：执行sql - 绑定接口
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. 关闭sqlSession
            sqlSession.close();
        }

    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
        System.out.println("=======================");
        User user2 = userDao.getUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        int res = mapper.addUser(new User(4, "哈哈", (byte) 1, 18, "12312341234"));
        if (res > 0) {
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    //万能map
    @Test
    public void addUser2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", 5);
        map.put("userName", "王五");
        map.put("telephone", "23333");
        mapper.addUser2(map);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(4, "嘿嘿", (byte) 1, 22, "12312346666"));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(4);
        sqlSession.commit();
        sqlSession.close();
    }
}
