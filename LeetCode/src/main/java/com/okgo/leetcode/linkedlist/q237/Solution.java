package com.okgo.leetcode.linkedlist.q237;

/**
 * @author Shawn
 * @date 2020/12/11 14:13
 * @title Function
 * 237. 删除链表中的节点 --
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        return;
    }
}
