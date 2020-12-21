package com.okgo.leetcode.linkedlist.q146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/11/21 9:26
 * @title Function TODO 重要！！！
 *
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 *
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    public LRUCache1(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache1 lruCache = new LRUCache1(3);
        lruCache.put(1, "a");
        lruCache.put(2, "b");
        lruCache.put(3, "c");
        System.out.println(lruCache.keySet());

        lruCache.put(4, "d");
        System.out.println(lruCache.keySet());
    }
}
