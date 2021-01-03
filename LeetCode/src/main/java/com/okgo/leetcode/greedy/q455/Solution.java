package com.okgo.leetcode.greedy.q455;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/12/31 10:52
 * @title Function
 * 贪心算法的实现，一般前提是排序好的数据
 */
/// Greedy Algorithm
/// Serve most greedy children first
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        if (g.length<1 || s.length<1) return 0;
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1, si = s.length - 1;
        while (gi >= 0 && si >= 0) {
            if (g[gi] <= s[si]) {
                res++;
                si--;
            }
            gi--;
        }
        return res;
    }

}

