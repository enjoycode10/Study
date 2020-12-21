package com.okgo.leetcode.dp.fibonacci.q70;

/**
 * @author Shawn
 * @date 2020/12/6 12:51
 * @title Function
 * 70. 爬楼梯 -- 动态规划
 */
public class Solution3 {
    private int[] memo;
    public int climbStairs(int n) {
        this.memo = new int[n+1];
        this.memo[0] = 1;
        this.memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
}
