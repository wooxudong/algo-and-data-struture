package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = head.next;
        while (even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            if (odd.next == null) {
                even.next = null;
                break;
            } else {
                even.next = odd.next;
                even = even.next;
            }
        }
        odd.next = evenHead;
        return head;
    }
}
