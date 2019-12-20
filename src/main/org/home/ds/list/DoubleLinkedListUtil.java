package org.home.ds.list;

public class DoubleLinkedListUtil {

    /*public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if(head == null){
            return head;
        }

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

        if(data<head.getData()){
            newNode.setNext(head);
            head.setPrev(newNode);
            return newNode;
        }

        DoublyLinkedListNode temp = head;
        while(temp.next != null && temp.next.next != null){
            if(data >= temp.data && data < temp.next.data ){
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next.prev = newNode;
            }
        }


    }*/
}
