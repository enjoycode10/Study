package com.okgo.leetcode.num1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shawn
 * @date 2020/7/24 22:42
 * @title Function
 */
public class Solution {

    /**
     * 1. 两数之和
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = i;
                result[1] = map.get(target - nums[i]);
                return result;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;

        /*// main test case
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }*/
    }
}
