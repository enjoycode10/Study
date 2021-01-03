package com.okgo.leetcode.dp.q198;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/12/6 16:24
 * @title Function
 * 198. 打家劫舍 -- 记忆搜索
 */
public class Solution1 {

    private static int[] memo;

    public static int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index...nums.length] 这个范围的所有房子
     * @param nums
     * @param index
     * @return
     */
    private static int tryRob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        int max = 0;
        for (int i = index; i < nums.length; i++) {
            max = Math.max(max, nums[i] + tryRob(nums, i+2));
        }
        return memo[index] = max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(rob(nums));
    }
}
