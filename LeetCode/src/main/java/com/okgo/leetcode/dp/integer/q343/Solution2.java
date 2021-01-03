package com.okgo.leetcode.dp.integer.q343;

/**
 * @author Shawn
 * @date 2020/12/6 14:21
 * @title Function
 */
public class Solution2 {
    public int integerBreak(int n) {
        assert n >= 2;
        int[] memo = new int[n + 1];
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            //求解memo[i]
            for (int j = 1; j < i; j++) { // 将 i 分割为 j + (i-j)
                memo[i] = max3(memo[i], j * (i-j), j * memo[i-j]);
            }

        }
        return memo[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
