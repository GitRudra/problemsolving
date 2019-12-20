package org.home.ds.list;


public class LinkedListUtil {

    /**
     * Reverse a linked list in memory. It will not create any more list.
     * Input: 1->2->3
     * Steps : 1. 2->1->3
     * Output:3->2->1
     *
     * @param head head of the passing list
     * @return
     */
    public static ListNode reverseListInPlace(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        } else {
            ListNode prevNode = null;
            ListNode curNode = head;
            ListNode nextNode = head.next;
            while (curNode != null) {
                nextNode = curNode.next;
                curNode.next = prevNode;
                prevNode = curNode;
                curNode = nextNode;
            }
            head = prevNode;
            return head;
        }
    }

    /**
     * Input: 1->2->3->4->5->6->7->8->9->10 K=3
     * Output:3->2->1->4->5->6->9->8->7->10
     * @param head
     * @param k
     */
    public static void reverseKAlterNativeNodes(ListNode head, int k){
        if(head == null || k==0){
            return;
        }else{
            /*ListNode reverseHead = null;
            ListNode temp = head;
            boolean reversing = true;
            int len = length(head);
            temp = reverseKNode(temp,k);*/
            ListNode returnNode = reverseKAltNode(head,k);
            printList(returnNode);
        }
    }

    private int length(ListNode head){
        int len =0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return  len;
    }

    private static ListNode reverseKAltNode(ListNode start, int k){
        int count = 0;
        ListNode prevNode=null;
        ListNode nextNode;
        ListNode currentNode = start;
        //Reverse first k node
        while(count<k && currentNode !=null){
            nextNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
            count++;

        }

        if(start!=null){
            start.next = currentNode;
        }

        count=0;
        while (count<k-1 && currentNode!=null){
            currentNode = currentNode.next;
            count++;
        }
        if(currentNode!=null){
            currentNode.next = reverseKAltNode(currentNode.next,k);
        }
        return prevNode;
    }

    public void swapNodeInPair(ListNode node){
        ListNode head =  null;

    }

    static class ListNode {
        int val;
        ListNode next;


        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public static void printList(ListNode head){
        while (head != null){
            System.out.print(head.val+"  ");
            head = head.next;
        }
        System.out.println("");
    }

    /**
     * The API retrun the value of the node which is the last
     * value of n%k=0. Where n is the number of nodes in the
     * list
     * @param head
     * @param k
     * @return
     */
    public static int findModularNode(ListNode head, int k){
        ListNode temp = head;
        ListNode result = null;
        int count=1;
        while(temp!=null){
            if(count%k==0){
                result = temp;
            }
            temp = temp.next;
            count++;
        }
        if(result != null){
            return result.val;
        }else
            return -111;
    }
}
