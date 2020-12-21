package com.okgo.leetcode.arr.slidewindows.q3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shawn
 * @date 2020/7/24 22:42
 * @title Function
 * 3. 无重复字符的最长子串 -- 滑动窗口
 */
public class Solution2 {


    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        if (s == null || s.length()<1) return result;
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (map.containsKey(c)){
                l = Math.max(map.get(c), l);
            }
            map.put(c, r+1);
            result = Math.max(result, r-l+1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }

}
