package com.okgo.leetcode.dp.knapsack01;

/**
 * @author Shawn
 * @date 2021/1/3 10:18
 * @title Function
 * 动态规划
 */
public class Solution5 {
    int[] memo;

    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[c + 1];
        for (int j = 0; j < c + 1; j++) {
            memo[j] = -1;
        }

        for (int j = 0; j < c + 1; j++) {
            memo[j] = (j >= w[0] ? v[0] : 0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j++) {
                memo[j] = Math.max(memo[j], v[i] + memo[j - w[i]]);
            }
        }
        return memo[c];
    }

}
