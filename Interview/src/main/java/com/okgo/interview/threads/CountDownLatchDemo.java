package com.okgo.interview.threads;

import com.okgo.interview.beans.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @author Shawn
 * @date 2020/6/20 12:27
 * @title 让一些线程阻塞，直到另一些线程完成一系列操作后才被唤醒：
 * CountDownLatch主要有两个方法，当一个或多个线程调用await()方法时，调用线程会被阻塞。
 * 其他线程调用countDown()方法会将计数器减 1，调用countDown()方法的线程不会阻塞。
 * 当计数器的值变为 0，因调用await()方法被阻塞的线程会被唤醒，继续执行。
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        closeDoor();
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭");
                count.countDown();
            }, CountryEnum.forEachCountryEnum(i).getRetMessage()).start();
        }

        count.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦，统华夏");
    }
}
