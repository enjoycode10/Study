package com.okgo.leetcode.binarytree.q144;

import com.okgo.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Shawn
 * @date 2020/12/11 17:04
 * @title Function
 * 144. 二叉树的前序遍历
 */
// My Non-Recursive
// Time Complexity: O(n), n is the node number in the tree
// Space Complexity: O(h), h is the height of the tree
public class Solution2 {

    private class Command{
        String s;   // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    };

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();

            if(command.s.equals("print"))
                res.add(command.node.val);
            else{
                assert command.s.equals("go");
                if(command.node.right != null)
                    stack.push(new Command("go",command.node.right));
                if(command.node.left != null)
                    stack.push(new Command("go",command.node.left));
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

}
