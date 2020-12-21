package com.okgo.leetcode.arr.q75;

/**
 * @author Shawn
 * @date 2020/12/7 21:08
 * @title Function
 * 75. 颜色分类
 */
class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            assert nums[i]>=0 && nums[i]<=2;
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }
}
