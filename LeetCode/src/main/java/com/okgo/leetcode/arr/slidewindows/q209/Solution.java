package com.okgo.leetcode.arr.slidewindows.q209;

/**
 * @author Shawn
 * @date 2020/12/10 10:35
 * @title Function
 * 209. 长度最小的子数组
 * 什么是子数组（是否要连续）
 * 如果没有解怎么办，返回0
 * 存在多个解怎么办，单个解的限定是什么，多个解的顺序有什么要求
 * 时间： O(n)
 * 空间： O(1)
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1; //nums[l...r]为滑动窗口，初始没有元素
        int sum = 0;
        int result = nums.length + 1;

        while (l < nums.length) {
            if (r+1 < nums.length &&sum < s) {
                sum += nums[++r];
            }else{
                sum -= nums[++l];
            }

            if (sum >= s) result = Math.min(result, r-l+1);
        }

        if (result == nums.length + 1) return 0;
        return result;
    }
}
