package com.okgo.interview.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Shawn
 * @date 2020/6/20 15:48
 * @title Function - 阻塞队列
 * <p>
 * 抛出异常
 * 当阻塞队列满时,再往队列里面add插入元素会抛IllegalStateException: Queue full
 * 当阻塞队列空时,再往队列Remove元素时候回抛出NoSuchElementException
 * 特殊值
 * 插入方法,成功返回true 失败返回false
 * 移除方法,成功返回元素,队列里面没有就返回null
 * 一直阻塞
 * 当阻塞队列满时,生产者继续往队列里面put元素,队列会一直阻塞直到put数据or响应中断退出
 * 当阻塞队列空时,消费者试图从队列take元素,队列会一直阻塞消费者线程直到队列可用.
 * 超时退出
 * 当阻塞队列满时,队列会阻塞生产者线程一定时间,超过后限时后生产者线程就会退出
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        /*System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());*/

        /*blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        System.out.println("=============");
        blockingQueue.put("d");

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());*/

        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("d", 2L, TimeUnit.SECONDS));

        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }
}
