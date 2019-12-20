package org.home.ds.list;

public class RunningOrderEncodingOfList {
    class LNode{
        private String data;
        private LNode next;

        public LNode(String data) {
            this.data = data;
            this.next = null;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }
    }

    public LNode getRunningOrderEncoding(LNode head){
        if(head==null || head.next==null){
            return head;
        }
        LNode rHead = null;
        LNode iTemp = head;
        LNode rTemp = null;
        String prevValue;
        String curValue;

        if(rHead==null){
            rHead = new LNode(head.data);
            rTemp = rHead;

        }
        curValue = head.data;
        iTemp = iTemp.next;
        int count = 1;

        while(iTemp!=null){
            prevValue = curValue;
            curValue = iTemp.data;
            if(curValue.equals(prevValue)){
                count++;
            }else{
                if(count>1){
                    if(count>9){
                        rTemp = createSubListForNumbers(count,rTemp);
                    }else{
                        rTemp.next = new LNode(String.valueOf(count));
                        rTemp = rTemp.next;
                    }

                    count = 1;

                }
                rTemp.next = new LNode(iTemp.data);
                rTemp = rTemp.next;

            }
            iTemp = iTemp.next;
        }


        return rHead;
    }

    private LNode createSubListForNumbers(int count,LNode rTemp){
        int digCount = 0;
        int tCount = count;
        while(tCount!=0){
            tCount =tCount/10;
            digCount++;
        }
        tCount = count;
        while(digCount>0){
            int divider=1;
            for(int i=0;i<digCount-1;i++){
                divider *=10;
            }
            //System.out.println("Count = "+tCount+" Divider = "+divider+ "  count/divider" + (tCount/divider));
            rTemp.next = new LNode(tCount/divider+"");
            rTemp = rTemp.next;
            tCount %= divider;
            digCount--;
        }

        return rTemp;
    }

    public LNode createList(String[] inputs){
        LNode head = new LNode(inputs[0]);
        LNode temp = head;
        for(int i=1;i<inputs.length;i++){
            temp.next = new LNode(inputs[i]);
            temp = temp.next;
        }

        return head;
    }

    public void printList(LNode head){
        while(head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
}
