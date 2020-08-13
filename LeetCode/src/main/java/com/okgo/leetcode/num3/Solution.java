package com.okgo.leetcode.num3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shawn
 * @date 2020/7/24 22:42
 * @title Function
 */
public class Solution {


    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.length() == 0) return result;
        Set<Character> set = new HashSet<>();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                result = Math.max(result, set.size());
            } else {
                while (set.contains(s.charAt(i))) {
                    set.remove(s.charAt(j));
                    j++;
                }
                set.add(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
