package com.okgo.mybatis.utils;

import java.util.UUID;

/**
 * @author Shawn
 * @date 2020/4/11 22:27
 * @title Function
 */
@SuppressWarnings("All")
public class IDutils {
    public static String getId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
