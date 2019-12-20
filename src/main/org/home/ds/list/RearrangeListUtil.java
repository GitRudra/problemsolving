package org.home.ds.list;

import java.util.ArrayList;
import java.util.List;

public class RearrangeListUtil {
    class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node NODE_REARRANGE = null;
    private boolean stopRearrange = false;

    public void reArrangeList(Node end){
        if(end.next == null){
            return;
        }
        if(NODE_REARRANGE == null){
            NODE_REARRANGE = end;
        }
        Node prev = end;
        end = end.next;
        reArrangeList(end);

        if(NODE_REARRANGE.next!=null && NODE_REARRANGE !=prev && !stopRearrange){
            prev.next = end.next;
            end.next = NODE_REARRANGE.next;
            NODE_REARRANGE.next = end;
            NODE_REARRANGE = NODE_REARRANGE.next.next;
        }else{
            stopRearrange = true;
        }
    }

    public int[] collectListNodes(Node head, int size){
        int[] collector = new int[size];
        int x=0;
        while(head != null){
            collector[x]=head.getValue();
            head = head.next;
            x++;
        }
        return collector;

    }

    public Node createLinkedList(int[] input){
        Node head = new Node(input[0]);
        Node temp = head;
        for(int i=1;i<input.length;i++){
            temp.next = new Node(input[i]);
            temp = temp.next;
        }
        return head;
    }
}
