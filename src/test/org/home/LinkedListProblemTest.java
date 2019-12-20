package org.home;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListProblemTest {

    @Test
    public void incrementByOneOne() throws Exception {
        LinkedListProblem obj = new LinkedListProblem();
        int input = 18326;
        Node head = createList(input);
        int expected = 18327;
        Node ret = obj.incrementByOne(head);
        int actual = getNumber(ret);
        assertEquals(expected,actual);
    }

    @Test
    public void incrementByOneTwo() throws Exception {
        LinkedListProblem obj = new LinkedListProblem();
        int input = 2899949;
        Node head = createList(input);
        int expected = 2899950;
        Node ret = obj.incrementByOne(head);
        int actual = getNumber(ret);
        assertEquals(expected,actual);
    }

    @Test
    public void incrementByOneThree() throws Exception {
        LinkedListProblem obj = new LinkedListProblem();
        int input = 999;
        Node head = createList(input);
        int expected = 1000;
        Node ret = obj.incrementByOne(head);
        int actual = getNumber(ret);
        System.out.println("Value : "+ actual);
        assertEquals(expected,actual);
    }

    private Node createList(int x){
        Node head = new Node(x%10);
        x = x/10;
        while(x!= 0){
            Node t = new Node(x%10);
            t.setNext(head);
            head = t;
            x = x/10;
        }
        return head;
    }

    private int getNumber(Node head){
        int x = 0;
        while(head != null){
            x = x*10+head.getValue();
            head = head.getNext();
        }
        return x;
    }
}