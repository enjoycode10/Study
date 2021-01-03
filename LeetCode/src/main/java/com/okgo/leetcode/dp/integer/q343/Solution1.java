package com.okgo.leetcode.dp.integer.q343;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/12/6 13:59
 * @title Function
 * 343. 整数拆分 -- 记忆化搜索
 */
public class Solution1 {
    private int[] memo;

    public int integerBreak(int n) {
        assert n >= 2;
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1) return 1;
        if (this.memo[n] != -1) return memo[n];
        int max = -1;
        for (int i = 1; i < n; i++) {
            max = max3(max, i * (n - i), i *  (n - i));
        }
        return this.memo[n] = max;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 1;
        //assert n>=2;
        assert m >= 2;
    }
}
