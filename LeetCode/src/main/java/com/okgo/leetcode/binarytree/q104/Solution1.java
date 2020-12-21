package com.okgo.leetcode.binarytree.q104;

/**
 * @author Shawn
 * @date 2020/12/11 22:22
 * @title Function
 * 104. 二叉树的最大深度
 */
// Recursive
// Time Complexity: O(n), where n is the nodes' number in the tree
// Space Complexity: O(h), where h is the height of the tree
class Solution1 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int maxDepth(TreeNode root) {

        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
