package com.okgo.interview.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Shawn
 * @date 2020/6/20 10:28
 * @title Function
 */
public class SpinLockDemo {
    AtomicReference<Thread> ar = new AtomicReference<>();
    AtomicInteger ai = new AtomicInteger(1);

    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "\t come in ...");
        while (!ar.compareAndSet(null, thread)) {
            System.out.println(thread.getName() + "\t" + ai.getAndIncrement());
        }
    }

    public void myUnlock() {
        Thread thread = Thread.currentThread();
        ar.compareAndSet(thread, null);
        System.out.println(thread.getName() + "\t come out ...");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "AAA").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "BBB").start();

    }
}
