package com.okgo.jwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shawn
 * @date 2020/7/5 2:29
 * @title Function
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String id;
    String username;
    String password;
}
