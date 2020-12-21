package com.okgo.leetcode.searchtable.q1;

import java.util.HashMap;

/**
 * @author Shawn
 * @date 2020/7/24 22:42
 * @title Function
 * 1. 两数之和 -- 哈希表
 * 索引从0还是1开始
 * 没有解怎么办？
 * 多个解怎么办？
 */
public class Solution {

    /**
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
