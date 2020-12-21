package com.okgo.leetcode.queue.priorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shawn
 * @date 2020/12/11 20:55
 * @title Function
 * 默认情况为最小堆
 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
 * 使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
 * ex: PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(50, (o1, o2) -> o2 - o1);
 */
public class TestPriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(50, (o1, o2) -> o2 - o1);
        for (int i = 0; i < 10; i++) {
            priorityQueue.add((int) (Math.random() * 100));
        }

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

    }
}
