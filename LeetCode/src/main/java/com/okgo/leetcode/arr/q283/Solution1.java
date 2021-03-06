package com.okgo.leetcode.arr.q283;

/**
 * @author Shawn
 * @date 2020/12/7 12:39
 * @title Function
 */
public class Solution1 {
    public static void moveZeroes(int[] nums) {
        int k = 0; //nums中，[0...K)的元素均为非0元素
        //遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列咋[0...k)中，同时，[k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i!=k){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
