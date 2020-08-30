package com.okgo.algo.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/8/30 11:44
 * @title Function
 */
public class BinarySearch {
    /**
     * 二分查找 时间复杂度O(log2n);空间复杂度O(1) 
     *
     * @param arr     被查找的数组 
     * @param left
     * @param right
     * @param target
     * @return 返回元素的索引
     */
    public static int binarySearch(int[] arr, int left, int right, int target) {
        if (left > right) {//递归退出条件，找不到，返回-1
            return -1;
        }
        int midIndex = (left + right) / 2;
        if (target < arr[midIndex]) {//向左递归查找  
            return binarySearch(arr, left, midIndex, target);
        } else if (target > arr[midIndex]) {//向右递归查找  
            return binarySearch(arr, midIndex, right, target);
        } else {
            return midIndex;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {

        //找不到条件?
        List<Integer> list = new ArrayList<>();

        if (left > right) {//递归退出条件，找不到，返回-1
            return list;
        }

        int midIndex = (left + right) / 2;
        int midVal = arr[midIndex];
        if (findVal < midVal) {//向左递归查找
            return binarySearch2(arr, left, midIndex - 1, findVal);
        } else if (findVal > midVal) { //向右递归查找
            return binarySearch2(arr, midIndex + 1, right, findVal);
        } else {
            System.out.println("midIndex=" + midIndex);

            //向左边扫描
            int temp = midIndex - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                if (arr[temp] == findVal) {
                    list.add(temp);
                }
                temp -= 1;
            }

            //将中间这个索引加入
            list.add(midIndex);

            //向右边扫描
            temp = midIndex + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                if (arr[temp] == findVal) {
                    list.add(temp);
                }
                temp += 1;
            }
            return list;
        }
    }

    public static void main(String[] args) {
        //注意：需要对已排序的数组进行二分查找  
        int[] data = {- 49, -30, -16, 9, 21, 21, 23, 30, 30
        };
        int i = binarySearch(data, 0, data.length, 21);
        System.out.println(i);
    }
}
