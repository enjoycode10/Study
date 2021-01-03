package com.okgo.leetcode.dp.knapsack01;

/**
 * @author Shawn
 * @date 2021/1/3 10:18
 * @title Function
 * 动态规划
 */
public class Solution4 {
    int[][] memo;
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[2][c+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c+1; j++) {
                memo[i][j] = -1;
            }
        }
        for (int j = 0; j < c+1; j++) {
            memo[0][j] = (j >= w[0] ? v[0]:0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c+1; j++) {
                memo[i%2][j] = memo[(i-1)%2][j];
                if (j>=w[i]) memo[i%2][j] = Math.max(memo[i%2][j], v[i]+memo[(i-1)%2][j-w[i]]);
            }
        }
        return memo[(n-1)%2][c];
    }

}
