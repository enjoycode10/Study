package com.okgo.interview.threads.threadlocal;

/**
 * @author Shawn
 * @date 2020/12/20 9:47
 * @title Function
 */
public class Test1 {
    static ThreadLocal<Integer> tl1 = new ThreadLocal<>();
    static ThreadLocal<Integer> tl2 = new ThreadLocal<>();
    static ThreadLocal<Integer> tl3 = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(tl1.get());
            tl1.set(11);
            System.out.println(tl1.get());

            System.out.println(tl2.get());
            tl2.set(12);
            System.out.println(tl2.get());

            System.out.println(tl3.get());
            tl3.set(13);
            System.out.println(tl3.get());
        }, "thread1");

        Thread t2 = new Thread(() -> {
            System.out.println(tl1.get());
            tl1.set(21);
            System.out.println(tl1.get());

            System.out.println(tl2.get());
            tl2.set(22);
            System.out.println(tl2.get());

            System.out.println(tl3.get());
            tl3.set(23);
            System.out.println(tl3.get());
        }, "thread2");

        t1.start();
        t1.join();
        t2.start();
    }
}
