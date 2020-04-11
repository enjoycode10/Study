package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.Blog;
import org.apache.ibatis.cache.Cache;

import java.util.List;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/4/11 22:20
 * @title Function
 */
public interface BlogDao {
    // 插入数据
    int addBlog(Blog blog);

    // 查询
    List<Blog> queryBlogIF(Map map);

    // 查询
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map map);

}
