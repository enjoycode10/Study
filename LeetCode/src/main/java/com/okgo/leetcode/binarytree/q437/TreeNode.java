package com.okgo.leetcode.binarytree.q437;

/**
 * @author Shawn
 * @date 2020/12/12 11:32
 * @title Function
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
