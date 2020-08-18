package com.okgo.interview.jvm;

import java.sql.DriverManager;

/**
 * @author Shawn
 * @date 2020/6/25 7:49
 * @title Function
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        try {
            // 1. 获取当前类的 ClassLoader
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            // 2. 获取当前线程上下文的 ClassLoader
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);

            // 3. 获取系统的 ClassLoader
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(systemClassLoader);

            // 4. 获取调用者的 ClassLoader
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
