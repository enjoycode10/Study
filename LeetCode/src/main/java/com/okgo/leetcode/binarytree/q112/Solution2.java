package com.okgo.leetcode.binarytree.q112;

import javafx.util.Pair;

import java.util.Stack;

/**
 * @author Shawn
 * @date 2020/12/11 22:46
 * @title Function
 */
// Non-Recursive
// Using Stack
//
// Time Complexity: O(n), where n is the nodes' number of the tree
// Space Complexity: O(h), where h is the height of the tree
public class Solution2 {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null)
            return false;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, sum));
        while(!stack.empty()){
            TreeNode cur = stack.peek().getKey();
            int num = stack.peek().getValue();
            stack.pop();

            if(num == cur.val && cur.left == null && cur.right == null)
                return true;

            if(cur.left != null)
                stack.push(new Pair<>(cur.left, num - cur.val));
            if(cur.right != null)
                stack.push(new Pair<>(cur.right, num - cur.val));
        }
        return false;
    }
}