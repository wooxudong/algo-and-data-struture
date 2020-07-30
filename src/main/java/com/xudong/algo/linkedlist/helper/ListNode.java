package com.xudong.algo.linkedlist.helper;

public class ListNode {
    public ListNode next;
    public int value;

    public ListNode(ListNode next, int value) {
        this.next = next;
        this.value = value;
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode() {
    }
}
