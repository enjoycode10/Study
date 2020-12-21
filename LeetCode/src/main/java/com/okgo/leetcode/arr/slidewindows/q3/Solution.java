package com.okgo.leetcode.arr.slidewindows.q3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shawn
 * @date 2020/7/24 22:42
 * @title Function
 * 3. 无重复字符的最长子串 -- 滑动窗口
 * 字符集是什么
 * 大小写是否敏感
 */
public class Solution {


    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.length() == 0) return result;
        Set<Character> set = new HashSet<>();
        int l = 0; // 左指针

        for (int r = 0; r < s.length(); r++) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                result = Math.max(result, set.size());
            } else {
                while (set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
            }
        }
        return result;
    }

}
