package com.okgo.leetcode.binarytree;

/**
 * @author Shawn
 * @date 2020/12/11 17:06
 * @title Function
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
