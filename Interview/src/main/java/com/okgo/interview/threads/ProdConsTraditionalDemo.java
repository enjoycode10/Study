package com.okgo.interview.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shawn
 * @date 2020/6/20 16:19
 * @title Function
 * 题目：一个初始值为 0 的变量，两个线程对其进行替换操作，一个加 1，一个减 1，来 5 轮
 * 步骤：
 * 1. 线程   操作  资源类
 * 2. 判断   干活  通知
 * 3. 防止虚假唤醒机制，while
 */

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {

        lock.lock();
        try {
            // 1. 判断
            while (number != 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2. 干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3. 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception {

        lock.lock();
        try {
            // 1. 判断
            while (number == 0) {
                // 等待，不能生产
                condition.await();
            }
            // 2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            // 3. 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}

public class ProdConsTraditionalDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BBB").start();
    }
}
