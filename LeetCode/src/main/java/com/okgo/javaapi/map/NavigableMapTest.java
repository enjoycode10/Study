package com.okgo.javaapi.map;

import java.util.TreeMap;

/**
 * @author Shawn
 * @date 2020/12/19 20:05
 * @title Function
 */
public class NavigableMapTest {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 1);
        treeMap.put(2, 2);
        treeMap.put(3, 3);
        treeMap.put(4, 4);
        treeMap.put(5, 5);
        treeMap.put(6, 6);
        treeMap.put(7, 7);
        treeMap.put(8, 8);

        System.out.println("ceilingEntry=>" + treeMap.ceilingEntry(3));
        System.out.println("floorEntry=>" + treeMap.floorEntry(3));
        System.out.println("navigableKeySet=>" + treeMap.navigableKeySet());
        System.out.println("floorEntry=>" + treeMap.floorEntry(3));
    }
}
