package com.okgo.leetcode.linkedlist.q2;


/**
 * @author Shawn
 * @date 2020/8/13 22:58
 * @title Function
 * 2. 两数相加 -- 双指针
 */
public class Solution {
    /**
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p1 = l1, p2 = l2, current = result;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = p1 == null ? 0 : p1.val;
            int y = p2 == null ? 0 : p1.val;
            int sum = x + y + carry;
            current.next = new ListNode(sum % 10);
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            carry = sum / 10;
        }
        if (carry>0) current.next = new ListNode(carry);
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}
