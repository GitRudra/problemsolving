package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class RearrangeListUtilTest {

    @Test
    public void testReArrangeListOne() {
        int[] input = {1,2,3,4,5};
        RearrangeListUtil util = new RearrangeListUtil();
        RearrangeListUtil.Node head = util.createLinkedList(input);
        int[] expected = {1,5,2,4,3};
        util.reArrangeList(head);
        int[] actual = util.collectListNodes(head,input.length);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void testReArrangeListTwo() {
        int[] input = {1,2,3,4,5,6};
        RearrangeListUtil util = new RearrangeListUtil();
        RearrangeListUtil.Node head = util.createLinkedList(input);
        int[] expected = {1,6,2,5,3,4};
        util.reArrangeList(head);
        int[] actual = util.collectListNodes(head,input.length);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void testReArrangeListThree() {
        int[] input = {1,2};
        RearrangeListUtil util = new RearrangeListUtil();
        RearrangeListUtil.Node head = util.createLinkedList(input);
        int[] expected = {1,2};
        util.reArrangeList(head);
        int[] actual = util.collectListNodes(head,input.length);
        assertArrayEquals(expected,actual);
    }
    @Test
    public void testReArrangeListFour() {
        int[] input = {1};
        RearrangeListUtil util = new RearrangeListUtil();
        RearrangeListUtil.Node head = util.createLinkedList(input);
        int[] expected = {1};
        util.reArrangeList(head);
        int[] actual = util.collectListNodes(head,input.length);
        assertArrayEquals(expected,actual);
    }
}