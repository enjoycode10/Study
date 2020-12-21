package com.okgo.leetcode.arr.q4;

/**
 * @author Shawn
 * @date 2020/8/14 0:19
 * @title Function
 * 4. 寻找两个正序数组的中位数 -- 二分法
 */
class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length, n = nums2.length;
        // 分割线左边所有的元素需要满足的个数 m+(n-m+1)/2;
        int totalLeft = (m + n + 1) / 2; // i+j = totalLeft

        // 在num1的区间[0, m]里查找恰当的分割线，使得 nums1[i-1]<=nums2[j] && nums2[j-1]<=nums1[i]
        int left = 0, right = m;
        while (left < right) {
            int i = left + (right - left + 1) / 2;
            int j = totalLeft - i;
            if (nums1[i - 1] > nums2[j]) {
                // 下一轮的搜索区间 [left, i-1]
                right = i - 1;
            } else {
                // 下一轮的搜索区间 [i, right]
                left = i;
            }
        }

        int i = left;
        int j = totalLeft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums1[j - 1];
        int nums2RightMin = j == m ? Integer.MAX_VALUE : nums1[j];

        if ((m+n)%2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }else {
            return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin))/2;
        }

    }

}