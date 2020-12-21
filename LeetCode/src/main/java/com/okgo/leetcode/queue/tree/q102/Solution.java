package com.okgo.leetcode.queue.tree.q102;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/11 17:45
 * @title Function
 * 102. 二叉树的层序遍历
 */
/// BFS
/// Time Complexity: O(n), where n is the number of nodes in the tree
/// Space Complexity: O(n)
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        //层序遍历，队列LinkedList，Pair<TreeNode, 第几层>
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> front = queue.removeFirst(); //取出队首元素
            TreeNode node = front.getKey();
            int level = front.getValue();

            if(level == res.size()) //新的一层，res中还没有
                res.add(new ArrayList<>());
            assert level < res.size();

            res.get(level).add(node.val);
            if(node.left != null)
                queue.addLast(new Pair<>(node.left, level + 1));
            if(node.right != null)
                queue.addLast(new Pair<>(node.right, level + 1));
        }

        return res;
    }
}
