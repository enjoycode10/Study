package com.okgo.leetcode.greedy.q435;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2021/1/1 17:25
 * @title Function
 */
/// Dynamic Programming based on starting point
/// Time Complexity:  O(n^2)
/// Space Complexity: O(n)
public class Solution1 {
    // Definition for an interval.
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length<1) return 0;
        Arrays.sort(intervals, (i1, i2) -> {
            if (i1.start!=i2.start) return i1.start - i2.start;
            return i1.end - i2.end;
        });

        // memo[i]表示使用intervals[0...i]的区间能构成的最长不重叠序列
        int[] memo = new int[intervals.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < intervals.length; i++) {
            // memo[i]
            for (int j = 0; j < i; j++) {
                if (intervals[i].start >= intervals[j].end)
                    memo[i] = Math.max(memo[i], 1+memo[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return intervals.length - res;
    }
}
