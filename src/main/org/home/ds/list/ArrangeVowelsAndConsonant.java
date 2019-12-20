package org.home.ds.list;

public class ArrangeVowelsAndConsonant {
     class ListNode{
        char val;
        ListNode next;


        public ListNode(char val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode rearrangeList(ListNode head){
         ListNode temp = head;
         ListNode prev = head;
         ListNode vPtr = null;   //r-u-d-r-a
         ListNode cpTemp;
         while(temp!=null){
             if(isVowel(temp.val)){
                 cpTemp = temp;
                 temp=temp.next;
                 if(vPtr==null){
                     vPtr = cpTemp;
                     vPtr.next = head;
                     head = vPtr;
                     //prev.next = cpTemp.next;
                 }else{
                     prev.next = cpTemp.next;
                     cpTemp.next = vPtr.next;
                     vPtr.next = cpTemp;
                     vPtr = vPtr.next;
                 }
             }else{
                 prev = temp;
                 temp = temp.next;
             }

         }

         return head;
    }

    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    ListNode createList(String s) {
         ListNode head = new ListNode(s.charAt(0));
         ListNode temp = head;
         for(int i=1;i<s.length();i++){
             temp.next = new ListNode(s.charAt(i));
             temp = temp.next;
         }

         return head;
    }

    public void printList(ListNode head){
         while(head!=null){
             System.out.print(head.val+" -> ");
             head = head.next;
         }
    }
}
