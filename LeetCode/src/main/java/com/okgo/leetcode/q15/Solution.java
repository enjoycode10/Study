package com.okgo.leetcode.q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/8/19 8:02
 * @title Function
 */
class Solution {
    /**
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，
     * 再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，
     * 计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {// 总时间复杂度：O(n^2)

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length <= 2) return result;
        Arrays.sort(nums); // O(nlogn)
        for (int i = 0; i < nums.length - 2; i++) { // O(n^2)
            if (nums[i] > 0) break; // 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过

            int target = -nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));

                    // 现在要增加 left，减小 right，但是不能重复，
                    // 比如: [-2, -1, -1, -1, 3, 3, 3], i = 0, left = 1, right = 6, [-2, -1, 3] 的答案加入后，需要排除重复的 -1 和 3
                    left++; right--; // 首先无论如何先要进行加减操作
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {  // nums[left] + nums[right] > target
                    right--;
                }
            }
        }
        return result;
    }
}
