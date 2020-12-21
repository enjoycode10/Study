package com.okgo.leetcode.recursion.backtracking.permutation.q46;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/12 17:31
 * @title Function
 * 46. 全排列 -- 回溯法 TODO 重要！！！
 */
// Most Naive Recursive
// Time Complexity: O(n^n)
// Space Complexity: O(n)
public class Solution1 {

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        //3. 定义返回结果
        res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;

        //6. 使用辅助数组
        used = new boolean[nums.length];

        //1. 递归函数入口
        LinkedList<Integer> p = new LinkedList<>();
        generatePermutation(nums, 0, p);

        return res;
    }

    /**
     *
     * @param nums 输入的数组
     * @param index 数组的第index元素的索引
     * @param p 在递归的过程中，p中保存了一个有index个元素的排列，向这个排列的末尾添加第index+1个元素，获得一个有index+1个元素的排列
     */
    private void generatePermutation(int[] nums, int index, LinkedList<Integer> p){

        //2. 递归终止条件
        if(index == nums.length){
            res.add((LinkedList<Integer>)p.clone());
            return;
        }

        //4. 递归过程：遍历数组的目的是为了找到第index+1个元素，且保证该元素不重复使用前index个元素
        for(int i = 0 ; i < nums.length ; i ++)
            //5. 判断num[i] 是否已经在 p中，不在才能添加
            if(!used[i]){
                used[i] = true;
                p.addLast(nums[i]);
                generatePermutation(nums, index + 1, p );
                //7. 恢复原状，继续找到第index+1个元素
                p.removeLast();
                used[i] = false;
            }
    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution1()).permute(nums);
        for(List<Integer> list: res)
            printList(list);
    }
}
