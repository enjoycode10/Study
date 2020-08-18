package com.okgo.interview.jvm;

/**
 * @author Shawn
 * @date 2020/7/4 8:56
 * @title Function
 */
public class RefCountGC {
    private byte[] bigSize = new byte[2*1024*1024];
    Object instance = null;

    public static void main(String[] args) {
        RefCountGC objA = new RefCountGC();
        RefCountGC objB = new RefCountGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}
