package com.xudong.algo.linkedlist.helper;

public class ListNode {
    public ListNode next;
    public int val;

    public ListNode(ListNode next, int value) {
        this.next = next;
        this.val = value;
    }

    public ListNode(int value) {
        this.val = value;
    }

    public ListNode() {
    }
}
