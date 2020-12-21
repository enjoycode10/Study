package com.okgo.leetcode.dp.fibonacci.q70;

/**
 * @author Shawn
 * @date 2020/12/6 12:51
 * @title Function
 * 70. 爬楼梯 -- 记忆化搜索
 */
public class Solution2 {
    private int[] memo;
    public int climbStairs(int n) {
        this.memo = new int[n+1];
        return calcWays(n);
    }

    private int calcWays(int n) {
        if (n == 0 || n == 1) return 1;
        if (memo[n] == 0) memo[n] = calcWays(n-1) + calcWays(n-2);
        return memo[n];
    }
}
