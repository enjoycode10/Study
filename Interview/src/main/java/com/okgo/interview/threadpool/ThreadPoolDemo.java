package com.okgo.interview.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2020/6/21 16:49
 * @title Function
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {

        // ExecutorService threadPool = Executors.newFixedThreadPool(5);// 一池 5 个处理线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();// 一池 1 个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();// 一池 N 个处理线程


        try {
            // 模拟 10 个用户办理业务，每个用户是一个来自外部的请求线程
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
