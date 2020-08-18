package com.okgo.interview.juc.locks;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Shawn
 * @date 2020/7/26 19:25
 * @title Function
 */
public class CASdemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2020)+"\t current: "+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current: "+atomicInteger.get());

        atomicInteger.getAndIncrement();
    }

}
