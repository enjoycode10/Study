package com.okgo.javaapi.thread.threadlocal1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Shawn
 * @date 2020/12/28 15:37
 * @title Function
 * 源码解析：
 * ThreadLocal主要方法有两个，一个set用来存储线程私有变量，一个get用来获取线程私有变量。
 */
public class InheritableThreadLocalUtils {
    private static final ThreadLocal<Integer> local = new InheritableThreadLocal<>();

    public static void set(Integer t) {
        local.set(t);
    }

    public static Integer get() {
        return local.get();
    }

    public static void remove() {
        local.remove();
    }

    static class TaskThread implements Runnable {

        Integer taskId;

        public TaskThread(Integer taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            InheritableThreadLocalUtils.set(taskId);
            //子线程
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(() -> {
                System.out.println(InheritableThreadLocalUtils.get());
            });
        }
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new TaskThread(i));
        }

    }
}


