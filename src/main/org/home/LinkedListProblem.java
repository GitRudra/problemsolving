package org.home;

public class LinkedListProblem {

    public Node incrementByOne(Node head) throws Exception {
        if(head == null){
            throw new Exception("Invalid input !!!");
        }
        Node temp = head;
        Node lastNonNineNode = null;
        Node returnHead;
        while(temp != null){
            if(temp.getValue() != 9){
                lastNonNineNode = temp;
            }
            temp = temp.getNext();
        }

        if(lastNonNineNode != null){
            temp = lastNonNineNode;
            lastNonNineNode.setValue(lastNonNineNode.getValue()+1);
            temp = temp.getNext();
            while(temp!= null){
                temp.setValue(0);
                temp = temp.getNext();
            }
            returnHead = head;
        }else {
            Node t = new Node(1);
            temp = head;
            while(temp != null){
                temp.setValue(0);
                temp = temp.getNext();
            }
            t.setNext(head);
            returnHead = t;
        }
        return returnHead;


    }
}
