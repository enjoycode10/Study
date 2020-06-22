package com.okgo.interview.threads;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2020/6/20 13:36
 * @title Function
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3); // 模拟3个停车位
        // 模拟6部车
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    // 模拟停车
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t 离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
