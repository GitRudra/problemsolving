package org.home.ds.list;

public class CircularLinkListUtil {
    class CirCularListNode{
        int val;
        CirCularListNode next;

        public CirCularListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    class ResultObject{
        CirCularListNode head;
        CirCularListNode head1;

        public CirCularListNode getHead() {
            return head;
        }

        public void setHead(CirCularListNode head) {
            this.head = head;
        }

        public CirCularListNode getHead1() {
            return head1;
        }

        public void setHead1(CirCularListNode head1) {
            this.head1 = head1;
        }
    }

    public CirCularListNode createList(int[] input){
        CirCularListNode head = new CirCularListNode(input[0]);
        CirCularListNode temp = head;
        for(int i=1;i<input.length;i++){
            temp.next = new CirCularListNode(input[i]);
            temp = temp.next;
        }
        temp.next = head;

        return head;
    }

    public void printCircularList(CirCularListNode head){
        CirCularListNode temp = head;
        System.out.print(temp.val);
        temp = temp.next;
        while(temp!=head){
            System.out.print(" -> "+temp.val);
            temp = temp.next;
        }
        System.out.println("");
    }

    /**
     * Split a circular link list in two half. If the list contain odd numbre
     * of elements then first one should contain middle element.
     * @param head
     * @return
     */
    public ResultObject divideCircularList(CirCularListNode head){
        CirCularListNode head1 = head;
        CirCularListNode head2;
        CirCularListNode slower = head;
        CirCularListNode faster = head;
        while(faster.next!= head && faster.next.next != head){
            slower = slower.next;
            faster = faster.next.next;
        }
        head2 = slower.next;
        slower.next = head;
        if(faster.next==head){
            faster.next = head2;
        }else if(faster.next.next==head){
            faster.next.next = head2;
        }

        ResultObject res = new ResultObject();
        res.setHead(head1);
        res.setHead1(head2);

        return res;

    }

    public CirCularListNode sortedInsertIntoCircularLinkList(CirCularListNode head, int key){
        if(head==null){
            return head;
        }
        CirCularListNode newNode = new CirCularListNode(key);
        if(head.next == head){
            if(head.val<=key){
                head.next = newNode;
                head.next.next = head;
            }else{
                newNode.next = head;
                head.next = newNode;
                head = newNode;
            }

        }else{
            CirCularListNode lastNode = getLastNode(head);
            if(head.val>=key){
                lastNode.next = newNode;
                newNode.next = head;
                head = newNode;
            }else if(key>=lastNode.val){
                newNode.next = lastNode.next;
                lastNode.next = newNode;
            }else{
                CirCularListNode prev = head;
                CirCularListNode cur = head.next;
                while(cur !=head){
                    if(key>= prev.val && key< cur.val){
                        newNode.next = cur;
                        prev.next = newNode;
                        break;
                    }

                    prev = cur;
                    cur = cur.next;
                }

            }
        }
        return head;
    }

    public CirCularListNode getLastNode(CirCularListNode head){
        CirCularListNode temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        return temp;
    }
}
