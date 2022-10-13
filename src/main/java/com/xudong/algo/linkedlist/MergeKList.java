package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;

import java.util.Arrays;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 *
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
 *
 * @author wooxudong
 */
public class MergeKList {
    public ListNode mergeKLists(ListNode[] listNodes) {
        if(listNodes == null || listNodes.length == 0) return null;
        return mergeKListsCursive(listNodes);
    }

    private ListNode mergeKListsCursive(ListNode[] nodes){
        if(nodes.length == 1) return nodes[0];
        if(nodes.length == 2) return merge2Lists(nodes[0], nodes[1]);

        ListNode mergedLeft = mergeKListsCursive(Arrays.copyOfRange(nodes, 0, nodes.length/2));
        ListNode mergeRight = mergeKListsCursive(Arrays.copyOfRange(nodes, nodes.length/2, nodes.length));
        return merge2Lists(mergedLeft, mergeRight);
    }

    public ListNode merge2Lists(ListNode l1, ListNode l2){
        ListNode merged = new ListNode();
        ListNode head = merged;
        while( l1!=null && l2!=null){
           if(l1.val < l2.val){
               merged.next = l1;
               merged = merged.next;
               l1 = l1.next;
           }else{
               merged.next = l2;
               merged = merged.next;
               l2 = l2.next;
           }
        }
        if(l1 != null) merged.next = l1;
        if(l2 != null) merged.next = l2;
        return head.next;
    }
}
