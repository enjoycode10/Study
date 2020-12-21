package com.okgo.leetcode.arr.q75;

/**
 * @author Shawn
 * @date 2020/12/7 21:08
 * @title Function
 * 75. 颜色分类
 */
class Solution1 {
    public void sortColors(int[] nums) {
        int zero = -1; // nums[0...zero] == 0
        int two = nums.length; // nums[two...n-1] == 2

        for (int i = 0; i < two; ) {
            if ( nums[i] == 1) i++;
            else if (nums[i] == 2) {
                int temp = nums[--two];
                nums[two] = nums[i];
                nums[i] = temp;
            }else if (nums[i] == 0) {
                int temp = nums[++zero];
                nums[zero] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
