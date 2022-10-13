package com.xudong.algo.linkedlist;

import com.xudong.algo.linkedlist.helper.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MergeKListTest {

    @Test
    void shouldReturnEmpty_ifNoinput() {
        //given
        ListNode[] listNodes = new ListNode[0];

        //when
        ListNode sorted = new MergeKList().mergeKLists(listNodes);

        //then
        assertThat(sorted).isNull();
    }

    @Test
    void shouldReturnOneList_ifOnlyOneListPresent() {
        //given
        ListNode list1 = generateLinkedList(1, 2, 3);
        ListNode[] listNodes = new ListNode[]{list1};

        //when
        ListNode sorted = new MergeKList().mergeKLists(listNodes);

        //then
        assertThat(isEqualTwoList(sorted, list1)).isTrue();
    }


    @Test
    void shouldReturnOneSortedList_ifMultipleListsPresent() {
        //given
        ListNode list1 = generateLinkedList(1, 4, 5);
        ListNode list2 = generateLinkedList(1, 3, 4);
        ListNode list3 = generateLinkedList(2, 6);

        ListNode[] listNodes = new ListNode[]{list1, list2, list3};

        //when
        ListNode sorted = new MergeKList().mergeKLists(listNodes);

        //then
        ListNode expected = generateLinkedList(1, 1, 2, 3, 4, 4, 5, 6);
        assertThat(isEqualTwoList(sorted, expected)).isTrue();
    }

    @Test
    void shouldReturnOneSortedList_ifTwoListsPresent() {
        //given
        ListNode list1 = generateLinkedList(1, 4, 5);
        ListNode list2 = generateLinkedList(1, 3, 4);


        //when
        ListNode sorted = new MergeKList().merge2Lists(list1, list2);

        //then
        ListNode expected = generateLinkedList(1, 1, 3,4,4,5);
        assertThat(isEqualTwoList(sorted, expected)).isTrue();
    }

    boolean isEqualTwoList(ListNode n1, ListNode n2) {
        if (n1 == null && n2 != null || n1 != null && n2 == null) return false;
        if (n1 == null) return true; //n1 and n2 have the same length

        if (n1.val != n2.val) return false;
        return isEqualTwoList(n1.next, n2.next);
    }

    ListNode generateLinkedList(int... values) {
        ListNode node = new ListNode();
        ListNode head = node;
        int length = values.length;
        int index = 0;
        while (index < length) {
            node.val = values[index];
            if (index != length - 1) {
                node.next = new ListNode();
                node = node.next;
            }
            index++;
        }
        return head;
    }
}
