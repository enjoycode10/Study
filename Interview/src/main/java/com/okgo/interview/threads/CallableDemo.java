package com.okgo.interview.threads;

import java.util.concurrent.Callable;

/**
 * @author Shawn
 * @date 2020/6/20 18:26
 * @title Function
 * Runnable 和 Callable 接口的区别
 * 1. 实现Callable接口的任务线程能返回执行结果，而实现Runnable接口的任务线程不能返回执行结果
 * 注意点：Callable接口支持返回执行结果，此时需要调用FutureTask.get()方法实现，此方法会阻塞线程直到获取“将来”的结果，当不调用此方法时，主线程不会阻塞
 * <p>
 * 2. Callable接口实现类中run()方法允许将异常向上抛出，也可以直接在内部处理(try...catch); 而Runnable接口实现类中run()方法的异常必须在内部处理掉，不能向上抛出
 * <p>
 * 3. 方法不一样，一个call(), 一个run()
 */
class MyThread implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return null;
    }
}

public class CallableDemo {
    public static void main(String[] args) {

    }
}
