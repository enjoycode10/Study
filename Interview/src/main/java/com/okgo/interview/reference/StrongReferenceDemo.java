package com.okgo.interview.reference;

/**
 * @author Shawn
 * @date 2020/8/8 10:22
 * @title Function
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); // 这样的引用，默认为强引用
        Object obj2 = obj1; // obj2引用复制
        obj1 = null; // 赋值
        System.gc();
        System.out.println(obj2); // java.lang.Object@1b6d3586
    }
}
