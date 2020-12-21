package com.okgo.leetcode.linkedlist.doublepoints.q19;

import java.util.List;

/**
 * @author Shawn
 * @date 2020/12/11 16:03
 * @title Function
 * 19. 删除链表的倒数第N个节点
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }

        while (q!=null){
            p = p.next;
            q = q.next;
        }

        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode = null;
        return dummyHead.next;
    }
}
