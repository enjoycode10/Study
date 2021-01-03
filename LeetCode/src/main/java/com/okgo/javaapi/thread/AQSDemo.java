package com.okgo.javaapi.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shawn
 * @date 2020/12/28 22:24
 * @title Function
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(); //NonFairSync
        lock.lock(); //sync.lock();

        lock.unlock(); //sync.release(1);
    }
}
