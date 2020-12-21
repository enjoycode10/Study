package com.okgo.leetcode.recursion.backtracking.combination.q77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/13 13:11
 * @title Function
 * TODO 重要！！！
 */
/// Naive Recursive
/// Time Complexity: O(n^k)
/// Space Complexity: O(k)
public class Solution1 {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        //3. 定义返回结果
        res = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n)
            return res;

        //1. 递归函数入口
        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    /**
     * 求解 C(n, k), 当前已经找到的组合存储在 c 中，需要从 start 开始搜索新的元素
     * @param n
     * @param k
     * @param start
     * @param c
     */
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c){

        //2. 递归终止条件
        if(c.size() == k){
            res.add((List<Integer>)c.clone());
            return;
        }

        //4. 递归过程：遍历数组的目的是为了找到第index+1个元素，且保证该元素不重复使用前index个元素
        //Solution2 做剪枝优化：还有 k-c.size() 个空位，所以[i...n]中至少要有k-c.size()个元素
        //i will at most be n - (k - c.size()) + 1
        for(int i = start ; i <= n ; i ++){
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }

    }

    private static void printList(List<Integer> list){
        for(Integer e: list)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution1()).combine(4, 2);
        for(List<Integer> list: res)
            printList(list);
    }
}