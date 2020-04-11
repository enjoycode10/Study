package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.Teacher;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Shawn
 * @date 2020/4/11 17:11
 * @title Function
 */
public interface TeacherDao {
    /*@Select("select * from test_teacher where id = #{tid}")*/
    Teacher getTeacher(@Param("tid") int id);
}
