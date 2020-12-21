package com.okgo.leetcode.arr.q283;

/**
 * @author Shawn
 * @date 2020/12/7 10:54
 * @title Function
 * 283. 移动零 -- 数组
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int[] nonZero = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nonZero[index] = nums[i];
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nonZero[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
