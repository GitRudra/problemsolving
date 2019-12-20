package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircularLinkListUtilTest {

    @Test
    public void createList() {
    }

    @Test
    public void printCircularList() {
    }

    @Test
    public void testDivideCircularListOne() {
        CircularLinkListUtil obj = new CircularLinkListUtil();
        int[] input = {1,2,3,4,5,6};
        CircularLinkListUtil.CirCularListNode head = obj.createList(input);
        obj.printCircularList(head);
        CircularLinkListUtil.ResultObject res = obj.divideCircularList(head);
        obj.printCircularList(res.getHead());
        obj.printCircularList(res.getHead1());
    }

    @Test
    public void testDivideCircularListTwo() {
        CircularLinkListUtil obj = new CircularLinkListUtil();
        int[] input = {1,2,3,4,5,6,7};
        CircularLinkListUtil.CirCularListNode head = obj.createList(input);
        obj.printCircularList(head);
        CircularLinkListUtil.ResultObject res = obj.divideCircularList(head);
        obj.printCircularList(res.getHead());
        obj.printCircularList(res.getHead1());
    }

    @Test
    public void testSortedInsertIntoCircularLinkListOne(){
        CircularLinkListUtil obj = new CircularLinkListUtil();
        int[] input = {1,3,4,6,7};
        CircularLinkListUtil.CirCularListNode head = obj.createList(input);
        obj.printCircularList(head);
        CircularLinkListUtil.CirCularListNode res = obj.sortedInsertIntoCircularLinkList(head,5);
        obj.printCircularList(res);
    }

    @Test
    public void testSortedInsertIntoCircularLinkListTwo(){
        CircularLinkListUtil obj = new CircularLinkListUtil();
        int[] input = {1,3,4,6,7};
        CircularLinkListUtil.CirCularListNode head = obj.createList(input);
        obj.printCircularList(head);
        CircularLinkListUtil.CirCularListNode res = obj.sortedInsertIntoCircularLinkList(head,8);
        obj.printCircularList(res);
    }

    @Test
    public void testSortedInsertIntoCircularLinkListThree(){
        CircularLinkListUtil obj = new CircularLinkListUtil();
        int[] input = {1,3,4,6,7};
        CircularLinkListUtil.CirCularListNode head = obj.createList(input);
        obj.printCircularList(head);
        CircularLinkListUtil.CirCularListNode res = obj.sortedInsertIntoCircularLinkList(head,0);
        obj.printCircularList(res);
    }
}