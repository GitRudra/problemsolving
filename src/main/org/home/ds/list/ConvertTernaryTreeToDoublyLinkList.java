package org.home.ds.list;

import org.home.ds.tree.TernaryTree;
import org.home.ds.tree.TernaryTreeNode;

public class ConvertTernaryTreeToDoublyLinkList {
    class DoublyListNode{
        int value;
        DoublyListNode next;
        DoublyListNode prev;

        public DoublyListNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private DoublyListNode head;
    private DoublyListNode tail;

    public ConvertTernaryTreeToDoublyLinkList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyListNode getHead() {
        return head;
    }

    public DoublyListNode getTail() {
        return tail;
    }

    public void createDoubleLinkList(TernaryTreeNode root){
        if(root==null){
            return;
        }
        createListUtil(root);
    }

    public void printDoublyList(DoublyListNode head){
        if(head!=null){
            System.out.print(head.value);
            head = head.next;
        }
        while(head!=null){
            System.out.print(" -> "+head.value);
            head = head.next;
        }
    }

    private void createListUtil(TernaryTreeNode root){
        if(root == null){
            return;
        }
        if(head==null){
            head = new DoublyListNode(root.getValue());
            tail = head;
        }else{
            tail.next = new DoublyListNode(root.getValue());
            tail.next.prev = tail;
            tail = tail.next;
        }

        createListUtil(root.getLeft());
        createListUtil(root.getMiddle());
        createListUtil(root.getRight());

    }


}
