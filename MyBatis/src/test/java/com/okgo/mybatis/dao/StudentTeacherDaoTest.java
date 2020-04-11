package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.Student;
import com.okgo.mybatis.model.Teacher;
import com.okgo.mybatis.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/11 17:17
 * @title Function
 */
public class StudentTeacherDaoTest {
    @Test
    public void testGetTeacher() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherDao mapper = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
    }

    @Test
    public void testGetStudentList() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.getStudentList();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
