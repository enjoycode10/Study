package com.okgo.leetcode.binarytree.q94;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/11 17:04
 * @title Function
 * 递归
 */
public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
