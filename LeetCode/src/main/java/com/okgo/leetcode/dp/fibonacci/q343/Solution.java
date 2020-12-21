package com.okgo.leetcode.dp.fibonacci.q343;

/**
 * @author Shawn
 * @date 2020/12/6 13:59
 * @title Function
 * 343. 整数拆分 -- 递归
 */
public class Solution {
    public int integerBreak(int n) {
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n==1) return 1;
        int max = -1;
        for (int i = 1; i < n; i++) {
            max = max3(max, i*(n-i), i*breakInteger(n-i));
        }
        return max;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
