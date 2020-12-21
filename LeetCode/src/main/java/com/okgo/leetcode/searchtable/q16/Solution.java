package com.okgo.leetcode.searchtable.q16;

import java.util.Arrays;

/**
 * @author Shawn
 * @date 2020/8/19 8:20
 * @title Function
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return Integer.MAX_VALUE;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 保证和上一次枚举的元素不相等
            
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int c = sum - target;

                if (c == 0) {
                    return target;
                } else if (c > 0) {
                    right--;
                } else {
                    left++;
                }

                if (Math.abs(c) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
