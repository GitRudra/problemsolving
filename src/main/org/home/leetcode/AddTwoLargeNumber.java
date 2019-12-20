package org.home.leetcode;


public class AddTwoLargeNumber {
    class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }
        return addTwoNumberUtil(l1,l2);
    }

    private ListNode addTwoNumberUtil(ListNode l1, ListNode l2){
        ListNode result = null;
        ListNode temp = null;
        int carryForward = 0;
        int digitSum ;
        while(l1 != null && l2 != null){
            digitSum = l1.val+l2.val+carryForward;
            carryForward = digitSum/10;
            digitSum = digitSum%10;
            if(result == null){
                result = new ListNode(digitSum);
                temp = result;
            }else{
                temp.next = new ListNode(digitSum);
                temp = temp.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1==null && l2==null && carryForward==1){
            temp.next = new ListNode(carryForward);
        }
        if(l1 == null && l2!=null){
            addRemaining(l2,temp,carryForward);
        }

        if(l2 == null && l1!=null){
            addRemaining(l1,temp,carryForward);
        }

        return result;
    }

    private void addRemaining(ListNode l, ListNode result, int carryForward){
        //int carryForward = 0;
        int digitSum;
        while(l!= null){
            digitSum = l.val+carryForward;
            carryForward = digitSum/10;
            digitSum = digitSum%10;
            result.next = new ListNode(digitSum);
            result = result.next;
            l = l.next;
        }
        if(carryForward == 1){
            result.next = new ListNode(carryForward);
        }
    }


}
