package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;

public class MergeTwoSortedLIst {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode merged = new ListNode();
        ListNode head = merged;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                merged.val = list1.val;
                list1 = list1.next;
            } else {
                merged.val = list2.val;
                list2 = list2.next;
            }
            merged.next = new ListNode();
            merged = merged.next;
        }
        if (list1 != null) {
            merged.val = list1.val;
            merged.next = list1.next;
        }
        if (list2 != null) {
            merged.val = list2.val;
            merged.next = list2.next;
        }
        return head;
    }
}
