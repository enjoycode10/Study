package com.okgo.leetcode.dp.lis.q300;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2021/1/3 16:00
 * @title Function
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        //memo[i] 表示以nums[i] 为结尾的最长上升子序列的长度
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    memo[i] = Math.max(memo[i], 1+memo[j]);
            }
        }

        int res = 1;
        for (int value : memo) {
            res = Math.max(res, value);
        }
        return res;
    }
}
