package com.okgo.swagger.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Shawn
 * @date 2020/4/6 13:01
 * @title Function
 */
@ApiModel("用户实体类 User Model")
public class User {
    @ApiModelProperty("用户标识")
    private Integer id;
    @ApiModelProperty("用户名称")
    private String username;
    @ApiModelProperty("用户密码")
    private String password;

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
