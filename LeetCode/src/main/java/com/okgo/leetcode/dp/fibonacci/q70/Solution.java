package com.okgo.leetcode.dp.fibonacci.q70;

/**
 * @author Shawn
 * @date 2020/12/6 12:37
 * @title Function
 * 70. 爬楼梯 -- 递归
 */
public class Solution {
    public int climbStairs(int n) {
        return calcWays(n);
    }

    private int calcWays(int n) {
        //初始代码
        //if (n == 1) return 1;
        //if (n == 2) return 2;

        //第一次优化
        //if (n == 0) return 1;
        //if (n == 1) return 1;

        //第二次优化
        if (n == 0 || n == 1) return 1;
        return calcWays(n - 1) + calcWays(n - 2);
    }
}
