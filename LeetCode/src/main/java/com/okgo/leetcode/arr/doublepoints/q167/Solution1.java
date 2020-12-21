package com.okgo.leetcode.arr.doublepoints.q167;

/**
 * @author Shawn
 * @date 2020/12/10 10:03
 * @title Function
 * 167. 两数之和 II - 输入有序数组 -- 双指针 O(n)
 */
public class Solution1 {
    public static int[] twoSum(int[] numbers, int target) throws Exception {
        assert numbers.length>=2:"stop";
        System.out.println("============");
        int[] result = new int[2];
        int l = 0, r = numbers.length;
        while(l < r) { //寻找两个不同索引，所以不可以相等
            if (numbers[l] + numbers[r] == target) {
                result[0] = l+1;
                result[1] = r+1;
                return result;
            }else if (numbers[l] + numbers[r] < target){
                l++;
            }else {
                r--;
            }
        }

        throw new Exception("The input has no solution.");
    }

    public static void main(String[] args) {
        int[] nums = new int[1];
        try {
            twoSum(nums, 3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
