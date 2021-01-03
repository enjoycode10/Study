package com.okgo.leetcode.dp.integer.q343;

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

    //将n进行分割（至少分割两部分），可以获得的最大乘积
    private int breakInteger(int n) {
        if (n == 1) return 1;
        int max = -1;
        for (int i = 1; i < n; i++) {
            //每次将 n 分割成 i + (n-i)，要考虑分割或不分割(n-i)两种情况
            max = max3(max, i * (n - i), i * breakInteger(n - i));
        }
        return max;
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
