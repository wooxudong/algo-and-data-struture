package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode faster = head;
        ListNode half = head;
        while (faster.next != null && faster.next.next != null) {
            half = half.next;
            faster = faster.next.next;
        }
        ListNode end;
        if (faster.next == null) end = faster;
        else end = faster.next;
        reverse(half.next);
        return solve(head, end);
    }

    private void reverse(ListNode node) {
        if (node.next == null) return;
        reverse(node.next);
        node.next.next = node;
        node.next = null;
    }

    private boolean solve(ListNode head, ListNode end) {
        while (end.next != null) {
            if (head.val != end.val) return false;
            head = head.next;
            end = end.next;
        }
        return end.val == head.val;
    }

}
