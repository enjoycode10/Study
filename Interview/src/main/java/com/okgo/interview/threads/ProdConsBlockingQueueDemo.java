package com.okgo.interview.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Shawn
 * @date 2020/6/20 17:35
 * @title Function
 * <p>
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 */
class ShareResource {
    private volatile boolean FLAG = true; // 默认开启，进行生产/消费
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public ShareResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); // 通过反射拿到类名和包名
    }

    public void myProd() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 阻塞队列插入 " + data + " 成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 阻塞队列插入 " + data + " 失败");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，FLAG = FALSE ");
    }

    public void myCons() throws Exception {
        String result = null;
        boolean retValue;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过2s未取到值，消费退出 ");
                System.out.println("\n\r");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列消费 " + result + " 成功");
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产，FLAG = FALSE ");
    }

    public void stop() throws Exception {
        this.FLAG = false;
    }
}

public class ProdConsBlockingQueueDemo {
    public static void main(String[] args) throws Exception {
        ShareResource resource = new ShareResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                resource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                resource.myCons();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Cons").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\t 5s时间已到，活动结束");
        resource.stop();
    }
}
