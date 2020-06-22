package com.okgo.interview.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Shawn
 * @date 2020/6/20 11:07
 * @title ReentrantReadWriteLock
 * <p>
 * 为了满足并发量，多个线程可同时读取一个共享资源，但如果有一个线程去写共享资源，其他线程就不应该对该资源进行读或写
 * 读 - 读 可共存
 * 读 - 写 不可共存
 * 写 - 写 不能共存
 * <p>
 * 写操作： 原子 + 独占
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {

        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入：" + key);
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成：" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }

    }

    public void get(String key) {

        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取：" + key);
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }

        for (int i = 1; i <= 5; i++) {
            final int tempInt = i;
            new Thread(() -> {
                cache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
