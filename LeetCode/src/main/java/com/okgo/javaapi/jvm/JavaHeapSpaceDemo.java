package com.okgo.javaapi.jvm;

/**
 * @author Shawn
 * @date 2020/12/25 9:12
 * @title Function
 */

import java.util.Random;

/**
 * @author Shawn
 * @date 2020/8/8 14:49
 * @title Function
 */
public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        //byte[] bytes = new byte[40 * 1024 * 1024];
        String str = "test";
        while (true){
            str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999);
            str.intern();
        }
        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}