package com.okgo.leetcode.linkedlist.q146;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/12/21 22:23
 * @title Function
 */
public class LRUCache2<K, V> {
    //map负责查找，构建一个虚拟的双向链表，它里面安装的就是一个个Node节点，作为数据载体。
    private int cacheSize;
    Map<K, Node<K, V>> map;
    DoubleLinkedList<K, V> doubleLinkedList;

    public LRUCache2(int cacheSize) {
        this.cacheSize = cacheSize;//坑位
        map = new HashMap<>();//查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    //1.构造一个node节点作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }

    }

    //2 构建一个虚拟的双向链表,,里面安放的就是我们的Node
    class DoubleLinkedList<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        //3. 添加到头
        public void addHead(Node<K, V> node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        //4.删除节点
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        //5.获得最后一个节点
        public Node<K, V> getLast() {
            return tail.prev;
        }
    }

    public V get(K key) {
        if (!map.containsKey(key)) { //key 不存在
            return null;
        }
        //将数据 (key, val) 提到开头
        Node<K, V> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    /**
     * if (key 已存在) {
     * 把旧的数据删除；
     * 将新节点 x 插入到开头；
     * } else {
     * if (cache 已满) {
     * 删除链表的最后一个数据腾位置；
     * 删除 map 中映射到该数据的键；
     * }
     * 将新节点 x 插入到开头；
     * map 中新建 key 对新节点 x 的映射；
     * }
     * saveOrUpdate method
     *
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        if (map.containsKey(key)) {  //update
            Node<K, V> node = map.get(key);
            node.value = value;
            map.put(key, node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            if (map.size() == cacheSize) { //坑位满了
                Node<K, V> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            //新增一个
            Node<K, V> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedList.addHead(newNode);

        }
    }

    public static void main(String[] args) {

        LRUCache2<Integer, Integer> lruCacheDemo = new LRUCache2<>(3);

        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 2);
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 1);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 1);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(5, 1);
        System.out.println(lruCacheDemo.map.keySet());

    }
}

/**
 * true
 * [1, 2, 3]
 * [2, 3, 4]
 * [2, 4, 3]
 * [2, 4, 3]
 * [2, 4, 3]
 * [4, 3, 5]
 * <p>
 * [1, 2, 3]
 * [2, 3, 4]
 * [2, 3, 4]
 * [2, 3, 4]
 * [2, 3, 4]
 * [3, 4, 5]
 * <p>
 * [1, 2, 3]
 * [2, 3, 4]
 * [2, 3, 4]
 * [2, 3, 4]
 * [2, 3, 4]
 * [3, 4, 5]
 */

/**
 [1, 2, 3]
 [2, 3, 4]
 [2, 3, 4]
 [2, 3, 4]
 [2, 3, 4]
 [3, 4, 5]
 */


