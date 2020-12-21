package com.okgo.leetcode.linkedlist.q206;

/**
 * @author Shawn
 * @date 2020/12/11 9:34
 * @title Function
 * 206. 反转链表 --
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }


}


public class Solution {
    public static ListNode reverseList(ListNode head) {
        //if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        //ListNode nxt = head.next;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
            //nxt = nxt.next;
        }
        return pre; //cur指向null
    }

    public static ListNode createLinkedList(int[] arr, int n){
        if (n == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head){
        ListNode curr = head;
        while (curr != null) {
            System.out.print("\t"+curr.val+"\t->");
            curr = curr.next;
        }
        System.out.print("\tnull\r\n");
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode head = createLinkedList(arr, arr.length);
        printLinkedList(head);

        ListNode head2 = reverseList(head);
        printLinkedList(head2);
    }
}
