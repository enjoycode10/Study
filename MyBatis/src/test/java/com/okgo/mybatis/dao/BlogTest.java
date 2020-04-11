package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.Blog;
import com.okgo.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/11 22:35
 * @title Function
 */
public class BlogTest {
    @Test
    public void testInsertBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogDao mapper = sqlSession.getMapper(BlogDao.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("title", "Spring如此简单");
        map.put("author", "Shawn");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogDao mapper = sqlSession.getMapper(BlogDao.class);
        HashMap map = new HashMap();
//        map.put("views",9999);
//        map.put("author","尹锐2");
        //map.put("title","Java如此简单2");
        map.put("id", "75c23f88ea6f4bc6ac4dc0a8f7afa373");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogDao mapper = sqlSession.getMapper(BlogDao.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}
