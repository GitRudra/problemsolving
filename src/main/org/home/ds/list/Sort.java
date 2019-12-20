package org.home.ds.list;

import java.util.Comparator;

public class Sort<E> {

    /**
     * MergeSort(headRef)
     * 1) If the head is NULL or there is only one element in the Linked List
     *     then return.
     * 2) Else divide the linked list into two halves.
     *       FrontBackSplit(head, &a, &b); // a and b are two halves
     * 3) Sort the two halves a and b.
     *       MergeSort(a);
     *       MergeSort(b);
     * 4) Merge the sorted a and b (using SortedMerge() discussed here)
     *    and update the head pointer using headRef.
     *      *headRef = SortedMerge(a, b);
     *
     * @param head
     * @param comp
     * @return
     */
    public ListNode<E> mergeSort(ListNode<E> head, Comparator<E> comp){
        ListNode<E> result = mergeSortUtil(head,comp);
        printList(result);
        return result;
    }

    private ListNode<E> findMid(ListNode<E> start){
        if(start == null){
            return start;
        }
        ListNode<E> slow = start;
        ListNode<E> fast = start.getNext();
        while(fast != null && fast.getNext()!= null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private ListNode<E> findEnd(ListNode<E> head){
        while(head.getNext()!= null){
            head = head.getNext();
        }
        return head;
    }

    private ListNode<E> mergeSortUtil(ListNode<E> start, Comparator comp){
        if(start == null || start.getNext() == null){
            return start;
        }
        ListNode<E> middle = findMid(start);
        ListNode<E> nextOfMid = middle.getNext();
        middle.setNext(null);
        ListNode<E> left = mergeSortUtil(start,comp);
        ListNode<E> right = mergeSortUtil(nextOfMid,comp);
        return sortedMerge(left,right,comp);
    }

    private ListNode<E> sortedMerge(ListNode<E> start,ListNode<E> mid, Comparator comp){
        if(start==null){
            return  mid;
        }
        if(mid == null){
            return start;
        }

        ListNode<E> result = null;

        if(comp.compare(start.getKey(),mid.getKey())<=0){
            result = start;
            result.setNext(sortedMerge(start.getNext(),mid,comp));
        }else{
            result = mid;
            result.setNext(sortedMerge(start,mid.getNext(),comp));
        }
        return result;
    }

    public void printList(ListNode<E> head){
        while(head != null){
            System.out.print( head.getKey() + " ");
            head = head.getNext();
        }

        System.out.println("");
    }
}
