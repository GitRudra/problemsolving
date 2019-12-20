package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class ModifyContentOfLinkListTest {

    @Test
    public void modifyContentOne() {
        ModifyContentOfLinkList modifier = new ModifyContentOfLinkList();
        int[] elements = {10, 4, 5, 3, 6};
        ModifyContentOfLinkList.LNode head = modifier.createLinkedList(elements);
        modifier.modifyContent(head);
        modifier.printList(head);
    }

    @Test
    public void modifyContentTwo() {
        ModifyContentOfLinkList modifier = new ModifyContentOfLinkList();
        int[] elements = {2, 9, 8, 12, 7, 10};
        ModifyContentOfLinkList.LNode head = modifier.createLinkedList(elements);
        modifier.modifyContent(head);
        modifier.printList(head);
    }

    @Test
    public void testUpdateNthNodeAsSumOfNthAndFirstNodeOne() {
        ModifyContentOfLinkList modifier = new ModifyContentOfLinkList();
        int[] elements = {2, 9, 8, 12, 7, 10};
        int[] expected = {2, 9, 8, 20, 16, 12};
        ModifyContentOfLinkList.LNode head = modifier.createLinkedList(elements);
        modifier.updateNthNodeAsSumOfNthAndFirstNode(head);
        int[] actual = modifier.collectListNodes(head, elements.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testUpdateNthNodeAsSumOfNthAndFirstNodeTwo() {
        ModifyContentOfLinkList modifier = new ModifyContentOfLinkList();
        int[] elements = {2, 9, 8, 12, 7, 10, 21};
        int[] expected = {2, 9, 8, 24, 15, 19, 23};
        ModifyContentOfLinkList.LNode head = modifier.createLinkedList(elements);
        modifier.updateNthNodeAsSumOfNthAndFirstNode(head);
        int[] actual = modifier.collectListNodes(head, elements.length);
        assertArrayEquals(expected, actual);
    }
}