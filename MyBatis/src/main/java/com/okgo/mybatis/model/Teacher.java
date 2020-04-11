package com.okgo.mybatis.model;

import lombok.Data;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/4/11 17:10
 * @title Function
 */
@Data
public class Teacher {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    // 一个老师有多个学生
    private List<Student> students;
}
