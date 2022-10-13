package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        int index = 0;
        while(index < n) {
            if(p2.next == null) {
                if(index == n-1) head = head.next;
                return head;
            }
            p2 = p2.next;
            index ++;
        }

        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == p2) return null;
        else{
            ListNode toRemove = p1.next;
            p1.next = toRemove.next;
            toRemove = null;
        }
        return head;
    }
}
