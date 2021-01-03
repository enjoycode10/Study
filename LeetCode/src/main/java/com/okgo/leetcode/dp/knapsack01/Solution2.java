package com.okgo.leetcode.dp.knapsack01;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2021/1/3 10:18
 * @title Function
 * 记忆化搜索
 */
public class Solution2 {
    int[][] memo;
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n][c+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c+1; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(w, v, n - 1, c);
    }

    /**
     * 用 [0...i] 的物品，填充容积为 c 的背包的最大价值
     *
     * @param w
     * @param v
     * @param i
     * @param c
     * @return
     */
    private int bestValue(int[] w, int[] v, int i, int c) {
        if (i < 0 || c <= 0) return 0;
        if (memo[i][c] != -1) return memo[i][c];
        int res = bestValue(w, v, i - 1, c);
        if (c>=w[i])
            res = Math.max(res, v[i] + bestValue(w,v,i-1,c-w[i]));
        return memo[i][c] = res;
    }
}
