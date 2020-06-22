package com.okgo.interview;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Shawn
 * @date 2020/6/13 9:30
 * @title Function
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2020) + "\t atomicInteger data:" + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t atomicInteger data:" + atomicInteger.get());
        /**
         * Atomically decrements by one the current value.
         *
         * @return the previous value
         */
        atomicInteger.getAndIncrement();
    }
}
