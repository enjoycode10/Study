package com.okgo.interview.jmm;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyNumber {
    volatile int number = 10;

    public void set1024(){
        this.number = 1024;
    }

    public synchronized void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}
/**
 * @author Shawn
 * @date 2020/7/4 10:24
 * @title Function
 *
 * JMM
 *      可见性：通知机制
 *
 */
public class VolatileTest {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();

        for (int i = 1; i <= 20; i++){
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myNumber.addPlusPlus();
                    myNumber.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        while(Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\tfinal number is: "+myNumber.number);
    }

    private static void visibility(MyNumber myNumber) {
        new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
            myNumber.set1024();
            System.out.println(Thread.currentThread().getName() + "\t : number value is " + myNumber.number);
        }, "A").start();

        while (myNumber.number == 10){
            // 需要有一种通知机制告诉main线程，number已经被修改为1024，可以跳出while
        }
        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }
}
