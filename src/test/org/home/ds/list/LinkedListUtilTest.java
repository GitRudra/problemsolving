package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListUtilTest {

    @Test
    public void reverseKAlterNativeNodes() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        LinkedListUtil.ListNode head = createList(input);
        LinkedListUtil.reverseKAlterNativeNodes(head,3);
    }

    @Test
    public void reverseListInPlace() {
        int[] input = {1,2,3};
        LinkedListUtil.ListNode head = createList(input);
        int[] expectedElements = {3,2,1};
        LinkedListUtil.ListNode expectedList = LinkedListUtil.reverseListInPlace(head);
        int[] actualElements = collectListElements(expectedList,input.length);
        assertArrayEquals(expectedElements,actualElements);
    }

    @Test
    public void testFindModularNodeOne() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        LinkedListUtil.ListNode head = createList(input);
        int expected = 9;
        int actual  = LinkedListUtil.findModularNode(head,3);
        assertEquals(expected,actual);
    }

    @Test
    public void testFindModularNodeTwo() {
        int[] input = {1,2,3,4,5,6,7,8,9,10};
        LinkedListUtil.ListNode head = createList(input);
        int expected = -111;
        int actual  = LinkedListUtil.findModularNode(head,13);
        assertEquals(expected,actual);
    }

    public void printList(LinkedListUtil.ListNode head){
        while (head != null){
            System.out.print(head.val+"  ");
            head = head.next;
        }
        System.out.println("");
    }

    public int[] collectListElements(LinkedListUtil.ListNode head, int size){
        int[] output = new int[size];
        int k=0;
        while(head!=null){
            output[k] = head.val;
            head = head.next;
            k++;
        }
        return output;
    }


    public LinkedListUtil.ListNode createList(int[] arr){
        LinkedListUtil.ListNode head = null;
        LinkedListUtil.ListNode temp = null;
        for(int i=0;i<arr.length;i++){
            if(head==null){
                head = new LinkedListUtil.ListNode(arr[i]);
                temp = head;
            }else{
                temp.next = new LinkedListUtil.ListNode(arr[i]);
                temp = temp.next;
            }

        }

        return head;
    }
}