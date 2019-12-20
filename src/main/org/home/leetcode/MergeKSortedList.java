package org.home.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNodeHeap{
    List<ListNode> heapList;
    int size;

    public ListNodeHeap() {
        this.heapList = new ArrayList<>();
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void percolateDown(int i){
        int left = 2*i+1;
        int right = 2*(i+1);
        int smallest = -1;

        if(left <size && heapList.get(i).getKey() > heapList.get(left).getKey()){
            smallest = left;
        }else{
            smallest = i;
        }

        if(right < size && heapList.get(smallest).getKey() > heapList.get(right).getKey()){
            smallest = right;
        }
        if(smallest != i){
            Collections.swap(heapList,i,smallest);
            percolateDown(smallest);
        }
    }

    private void doHeapify(){
        for(int i=0;i<size/2;i++){
            percolateDown(i);
        }
    }

    public void insertIntoHeap(ListNode node){
        heapList.add(node);
        size++;
        doHeapify();
    }

    public ListNode getMin(){
        ListNode ret = heapList.get(0);
        ListNode nextNode = heapList.get(0).getNext();
        if(nextNode == null){
            heapList.remove(0);
            size--;
        }else{
            heapList.set(0,nextNode);
            doHeapify();
        }
        return ret;
    }


}

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
       ListNodeHeap heap = new ListNodeHeap();
       for(ListNode l : lists){
           heap.insertIntoHeap(l);
       }
       ListNode head = new ListNode(heap.getMin().getKey());
       ListNode temp = head;
       while(!heap.isEmpty()){
          temp.setNext(new ListNode(heap.getMin().getKey()));
          temp = temp.getNext();
       }
       /*temp = head;
       while(temp != null){
           System.out.print(temp.getKey()+ " ");
           temp = temp.getNext();
       }*/

       return head;

    }

    /*private ListNode getMinimum(ListNode[] lists){
        ListNode ret = lists[0];
        lists[0] = lists[0].getNext();
        doMinHeapify(lists);
        return ret;
    }

    private void doMinHeapify(ListNode[] lists){
        for(int i=0; i<lists.length/2;i++){
            percolateDown(lists,i,lists.length);
        }

    }*/



}
