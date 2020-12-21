package com.okgo.leetcode.linkedlist.dummyhead.q203;

/**
 * @author Shawn
 * @date 2020/12/11 10:37
 * @title Function
 * 203. 移除链表元素 -- TODO 重要！！！
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head!=null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        if (head == null) return null;

        ListNode curNode = head;
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
        return head;
    }
}
