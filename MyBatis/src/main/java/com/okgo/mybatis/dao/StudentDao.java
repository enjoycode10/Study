package com.okgo.mybatis.dao;

import com.okgo.mybatis.model.Student;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/11 17:11
 * @title Function
 */
public interface StudentDao {
    List<Student> getStudentList();
}
