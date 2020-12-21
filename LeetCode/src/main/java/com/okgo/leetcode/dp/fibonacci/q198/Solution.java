package com.okgo.leetcode.dp.fibonacci.q198;

/**
 * @author Shawn
 * @date 2020/12/6 16:24
 * @title Function
 * 198. 打家劫舍 -- 递归 状态转移
 */
public class Solution {
    public int rob(int[] nums) {
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index...nums.length] 这个范围的所有房子
     * @param nums
     * @param index
     * @return
     */
    private int tryRob(int[] nums, int index) {
        if (index >= nums.length) return 0;
        int max = 0;
        for (int i = index; i < nums.length; i++) {
            Math.max(max, nums[i]+ tryRob(nums, i+2));
        }
        return max;
    }
}
