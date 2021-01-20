package com.okgo.interview.juc.locks;

import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2020/12/20 22:41
 * @title Function
 */
public class HoldThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockA + "尝试获得" + lockB);
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "\t 自己持有锁" + lockB + "尝试获得" + lockA);
            }
        }
    }

    public static void main(String[] args) {
        String lockA = "A";
        String lockB = "B";
        new Thread(new HoldThread(lockA, lockB),"threadAAA").start();
        new Thread(new HoldThread(lockB, lockA),"threadBBB").start();
    }
}
