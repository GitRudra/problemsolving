package org.home.ds.list;

import java.util.Comparator;

/**
 * Given singly linked list with every node having an additional “arbitrary”
 * pointer that currently points to NULL.
 * Need to make the “arbitrary” pointer point to the next higher value node.
 *
 * An Efficient Solution works in O(nLogn) time. The idea is to use Merge Sort for linked list.
 * 1) Traverse input list and copy next pointer to arbit pointer for every node.
 * 2) Do Merge Sort for the linked list formed by arbit pointers.
 * @param <E>
 */
public class SortedListByRandomPointer<E> {

    public ListNode<E> fixRandomPointer(ListNode<E> head, Comparator comp){
        Sort<E> sort = new Sort<>();
        storeNextPtr(head);
        ListNode<E> headOrg = head;
        head = sort.mergeSort(head, comp);
        swapNode(headOrg);
        return head;
    }

    public void printListUsingRandomPointer(ListNode<E> h){
        while(h != null){
            System.out.println(h.getKey()+" ");
            h = h.getRandom();
        }
    }

    private void storeNextPtr(ListNode<E> h){
        while(h!= null){
            h.setRandom(h.getNext());
            h = h.getNext();
        }
    }

    private void swapNode(ListNode<E> h){
        while(h!=null){
            ListNode<E> node = h.getNext();
            h.setNext(h.getRandom());
            h.setRandom(node);
            h = h.getNext();
        }
    }
}
