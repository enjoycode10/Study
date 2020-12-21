package com.okgo.leetcode.binarytree.searchtree.q235;

/**
 * @author Shawn
 * @date 2020/12/12 12:09
 * @title Function
 */
// Non-Recursive
// Time Complexity: O(lgn), where n is the node's number of the tree
// Space Complexity: O(1)
class Solution2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null)
            return root;

        TreeNode cur = root;
        while(cur != null){
            if(p.val < cur.val && q.val < cur.val)
                cur = cur.left;
            else if(p.val > cur.val && q.val > cur.val)
                cur = cur.right;
            else
                return cur;
        }
        return  null;
    }
}