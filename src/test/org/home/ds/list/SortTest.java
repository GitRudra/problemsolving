package org.home.ds.list;

import org.home.algo.sorting.MergeSort;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class SortTest {

    @Test
    public void testMergeSortOne() {
        Sort<Integer> sort = new Sort();
        int[] input = {3,1,5,9,7,4,2,8,6,10};
        ListNode<Integer> head = createIntegerList(input);
        sort.printList(head);
        ListNode<Integer> sortedList = sort.mergeSort(head, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        sort.printList(sortedList);

    }

    private ListNode<Integer> createIntegerList(int[] input){
        ListNode<Integer> head = new ListNode<>(input[0]);
        ListNode<Integer> temp = head;
        for(int i=1;i<input.length;i++){
            temp.setNext(new ListNode<>(input[i]));
            temp = temp.getNext();
        }
        return head;

    }


}