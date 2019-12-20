package org.home.ds.list;

import org.junit.Test;

public class ArrangeVowelsAndConsonantTest {

    @Test
    public void testRearrangeListOne() {
        String inputStr  = "rudra";
        ArrangeVowelsAndConsonant arranger = new ArrangeVowelsAndConsonant();
        ArrangeVowelsAndConsonant.ListNode head = arranger.createList(inputStr);
        head = arranger.rearrangeList(head);
        arranger.printList(head);
    }

    @Test
    public void testRearrangeListTwo() {
        String inputStr  = "oracle";
        ArrangeVowelsAndConsonant arranger = new ArrangeVowelsAndConsonant();
        ArrangeVowelsAndConsonant.ListNode head = arranger.createList(inputStr);
        arranger.rearrangeList(head);
        arranger.printList(head);
    }
}