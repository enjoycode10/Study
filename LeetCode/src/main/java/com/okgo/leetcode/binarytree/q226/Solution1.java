package com.okgo.leetcode.binarytree.q226;

/**
 * @author Shawn
 * @date 2020/12/11 22:29
 * @title Function
 * 226. 翻转二叉树
 */
// Recursive
// Time Complexity: O(n), where n is the node's number of the tree
// Space Complexity: O(h), where h is the height of the tree
public class Solution1 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}
