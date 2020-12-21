package com.okgo.leetcode.dp.fibonacci.q198;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/12/6 16:24
 * @title Function
 * 198. 打家劫舍 -- 记忆搜索
 */
public class Solution2 {

    private static int[] memo;

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        memo[n-1] = nums[n-1]; //memo[i] 表示考虑抢劫 nums[i...n-1] 所能获得的最大收益
        int max = 0;
        for (int i = n-2; i >= 0; i--) {
            // memo[i]
            for (int j = i; j < n; j++) {
                memo[i] = Math.max(memo[i], nums[j] + (j+2<n?memo[j+2]:0));
            }
        }

        return memo[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}
