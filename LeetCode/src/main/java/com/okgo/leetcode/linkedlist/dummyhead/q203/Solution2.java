package com.okgo.leetcode.linkedlist.dummyhead.q203;

/**
 * @author Shawn
 * @date 2020/12/11 11:04
 * @title Function
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next!=null){
            if (curNode.next.val == val){
                //删除cur.next
                ListNode delNode = curNode.next;
                curNode.next = curNode.next.next;
                delNode.next = null;
            }else{
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }
}