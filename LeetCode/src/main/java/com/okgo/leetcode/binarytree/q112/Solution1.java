package com.okgo.leetcode.binarytree.q112;

/**
 * @author Shawn
 * @date 2020/12/11 22:43
 * @title Function
 */
// Recursive
// Time Complexity: O(n), where n is the nodes' number of the tree
// Space Complexity: O(h), where h is the height of the tree
class Solution1 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        if(root.left == null && root.right == null)
            return sum == root.val;

        return hasPathSum(root.left, sum - root.val)
                || hasPathSum(root.right, sum - root.val);
    }
}
