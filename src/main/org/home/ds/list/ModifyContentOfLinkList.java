package org.home.ds.list;


/**
 * Given a singly linked list containing n nodes.
 * Modify the value of first half nodes such that 1st node’s new value
 * is equal to the last node’s value minus first node’s current value,
 * 2nd node’s new value is equal to the second last node’s value minus
 * 2nd node’s current value, likewise for first half nodes.
 * If n is odd then the value of the middle node remains unchanged.
 * (No extra memory to be used).
 */
public class ModifyContentOfLinkList {
    class LNode {
        private int value;
        private LNode next;

        public LNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append("->");
            if (next == null) {
                sb.append("");
            }
            return sb.toString();
        }
    }

    public LNode createLinkedList(int[] input) {
        LNode head = new LNode(input[0]);
        LNode temp = head;
        for (int i = 1; i < input.length; i++) {
            temp.next = new LNode(input[i]);
            temp = temp.next;
        }
        return head;
    }

    public void printList(LNode head) {
        while (head != null) {
            System.out.print(head);
            head = head.next;
        }
    }

    /**
     * Modify 1st node as nth node -1st node
     *
     * @param head head of the source list
     */
    public void modifyContent(LNode head) {
        LNode mid = findMiddleOfList(head);
        modify(head, mid);
    }


    /**
     * Method to do the modification of link list nodes.
     * This is an iterative method which takes two parameters.
     * Middle of the list <code>mid</code> and start of the list
     * <code>start</code>. The idea is this method will be called
     * iteratively from middle of the node and each call we move the
     * mid pointer to its next node. Now when the mid pointer reaches end
     * of list then we need to subtract the value of last and first node. So
     * as terminating state the method return start pointer and each recursive call
     * it returns pointer start->next.
     *
     * @param start
     * @param mid
     * @return
     */
    private LNode modify(LNode start, LNode mid) {
        if (mid == null) {
            return start;
        }

        start = modify(start, mid.next);
        if (start != mid) {
            start.value = start.value - mid.value;
        }

        return start.next;
    }

    private LNode findMiddleOfList(LNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head;
        }
        LNode fastPointer = head;
        LNode slowPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        return slowPointer;
    }

    private LNode updateNthNodeAsSumOfNthAndFirstNodeUtil(LNode start, LNode mid) {
        if (mid == null) {
            return start;
        }
        start = updateNthNodeAsSumOfNthAndFirstNodeUtil(start, mid.next);
        //if(start != mid){
        mid.value = mid.value + start.value;
        //}

        return start.next;
    }


    /**
     * Given a Singly Linked list, Update the second half of the list such that
     * n-th element becomes sum(1st + nth) element,
     * (n-1)st element becomes sum(2nd + n-1st) element and so on
     *
     * @param head head of the input list
     */
    public void updateNthNodeAsSumOfNthAndFirstNode(LNode head) {
        if (head == null || head.next == null) {
            return;
        }
        LNode mid = findMiddleOfList(head);
        updateNthNodeAsSumOfNthAndFirstNodeUtil(head, mid);
    }

    public int[] collectListNodes(LNode head, int size) {
        int[] collector = new int[size];
        int x = 0;
        while (head != null) {
            collector[x] = head.value;
            head = head.next;
            x++;
        }
        return collector;

    }
}
