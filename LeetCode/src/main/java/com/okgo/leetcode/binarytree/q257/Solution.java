package com.okgo.leetcode.binarytree.q257;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/12 10:28
 * @title Function
 * 257. 二叉树的所有路径
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;

        //判断是否为叶子结点（和指针有关的操作要考虑null的情况）
        if (root.left == null && root.right == null){
            result.add(String.valueOf(root.val));
            return result;
        }
        List<String> leftS = binaryTreePaths(root.left);
        for (int i = 0; i < leftS.size(); i++) {
            result.add(root.val +"->"+leftS.get(i));
        }

        List<String> rightS = binaryTreePaths(root.right);
        for (int i = 0; i < rightS.size(); i++) {
            result.add(root.val +"->"+ rightS.get(i));
        }

        return result;
    }
}
