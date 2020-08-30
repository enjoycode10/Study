package com.okgo.leetcode.test;

/**
 * @author Shawn
 * @date 2020/8/24 23:59
 * @title Function
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(",");
        List<String> result = findDoubleElement(strs);
        for (String s : result) {
            System.out.print(s + " ");
        }


    }

    private static List<String> findDoubleElement(String[] strs) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        if (strs == null || strs.length < 2) return result;
        for (String s : strs) {
            if (map.containsKey(s)) {
                int count = map.get(s);
                map.put(s, count + 1);
            }else{
                map.put(s, 1);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) == 2) result.add(key);
        }
        return result;
    }

}