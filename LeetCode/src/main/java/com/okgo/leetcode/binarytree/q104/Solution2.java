package com.okgo.leetcode.binarytree.q104;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author Shawn
 * @date 2020/12/11 22:26
 * @title Function
 */
// Non-recursive
// Time Complexity: O(n), where n is the nodes' number in the tree
// Space Complexity: O(h), where h is the height of the tree
class Solution2 {

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

        Stack<Pair<TreeNode, Integer>> s = new Stack<Pair<TreeNode, Integer>>();
        s.add(new Pair(root, 1));
        int res = 0;
        while(!s.empty()){
            TreeNode curNode = s.peek().getKey();
            int depth = s.peek().getValue();
            s.pop();

            if(curNode.left == null && curNode.right == null)
                res = Math.max(res, depth);
            else{
                if(curNode.left != null)
                    s.push(new Pair(curNode.left, depth + 1));
                if(curNode.right != null)
                    s.push(new Pair(curNode.right, depth + 1));
            }
        }

        return res;
    }
}
