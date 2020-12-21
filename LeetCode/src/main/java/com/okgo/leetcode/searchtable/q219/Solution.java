package com.okgo.leetcode.searchtable.q219;

import java.util.HashSet;

/**
 * @author Shawn
 * @date 2020/12/10 23:08
 * @title Function
 * 219. 存在重复元素 II -- 滑动窗口 + 查找表
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> records = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (records.contains(nums[i])) return true;
            records.add(nums[i]);
            if (records.size() == k+1) records.remove(nums[i-k]);
        }
        return false;
    }
}
