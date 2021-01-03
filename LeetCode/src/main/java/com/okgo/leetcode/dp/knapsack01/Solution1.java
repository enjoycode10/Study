package com.okgo.leetcode.dp.knapsack01;

/**
 * @author Shawn
 * @date 2020/12/6 19:17
 * @title Function
 * 递归
 */
public class Solution1 {
    public int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
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
        int res = bestValue(w, v, i - 1, c);
        if (c>=w[i])
            res = Math.max(res, v[i] + bestValue(w,v,i-1,c-w[i]));
        return res;
    }
}
