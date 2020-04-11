package com.okgo.mybatis.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Shawn
 * @date 2020/4/11 22:17
 * @title Function
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
