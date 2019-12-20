package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeKSortedListTest {

    @Test
    public void mergeKLists() {
        //1->4->5,
        //  1->3->4,
        //  2->6
        ListNode[] lists = new ListNode[4];
        int[] list1 = {3,4,5};
        int[] list2 = {2,3,4};
        int[] list3 = {1,6};
        int[] list4 = {1,8};
        lists[0] = createList(list1);
        lists[1] = createList(list2);
        lists[2] = createList(list3);
        lists[3] = createList(list4);
        MergeKSortedList merger = new MergeKSortedList();
        merger.mergeKLists(lists);
    }


    private ListNode createList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for(int i= 1; i<arr.length;i++){
            temp.setNext(new ListNode(arr[i]));
            temp = temp.getNext();
        }

        return head;

    }
}