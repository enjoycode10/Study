package com.okgo.leetcode.linkedlist.dummyhead.q24;

/**
 * @author Shawn
 * @date 2020/12/11 11:23
 * @title Function
 * 24. 两两交换链表中的节点 -- TODO 重要！！！
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        return dummyHead.next;
    }
}
