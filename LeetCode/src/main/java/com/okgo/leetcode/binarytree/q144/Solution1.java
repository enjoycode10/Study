package com.okgo.leetcode.binarytree.q144;

import com.okgo.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/11 17:04
 * @title Function
 * 144. 二叉树的前序遍历
 */
// Recursive
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list){
        if(node != null){
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }
}
