package com.okgo.interview.reference;

import java.lang.ref.WeakReference;

/**
 * @author Shawn
 * @date 2020/8/8 10:47
 * @title Function
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> softReference = new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());

//        java.lang.Object@1b6d3586
//        java.lang.Object@1b6d3586
//        null
//        null

    }
}
