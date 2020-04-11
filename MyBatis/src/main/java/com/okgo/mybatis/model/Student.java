package com.okgo.mybatis.model;

import lombok.Data;

/**
 * @author Shawn
 * @date 2020/4/11 17:02
 * @title Function
 */
@Data
public class Student {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int tid;
    private Teacher teacher;
}
