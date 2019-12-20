package org.home.ds.list;

public class MergeList{

    public NodeInt mergeList(NodeInt list1, NodeInt list2){
        NodeInt result = null;
        NodeInt temp   = null;
        while(list1!= null && list2!=null){
            if(list1.getKey() <= list2.getKey()){
                if(result==null){
                    result = list1;
                    temp = list1;
                }else {
                    temp.setNext(list1);
                    temp = temp.getNext();
                }
                list1 = list1.getNext();
            }else{
                if(result==null){
                    result = list2;
                    temp = list2;
                }else {
                    temp.setNext(list2);
                    temp = temp.getNext();
                }
                list2 = list2.getNext();
            }
        }
        if(list1 != null){
            temp.setNext(list1);
        }
        if(list2!=null){
            temp.setNext(list2);
        }

        return result;
    }

    public NodeInt mergeListUsingDownPointer(NodeInt list1, NodeInt list2){
        NodeInt result = null;
        NodeInt temp   = null;
        while(list1!= null && list2!=null){
            if(list1.getKey() <= list2.getKey()){
                if(result==null){
                    result = list1;
                    temp = list1;
                }else {
                    temp.setDown(list1);
                    temp = temp.getDown();
                }
                list1 = list1.getDown();
            }else{
                if(result==null){
                    result = list2;
                    temp = list2;
                }else {
                    temp.setDown(list2);
                    temp = temp.getDown();
                }
                list2 = list2.getDown();
            }
        }
        if(list1 != null){
            temp.setDown(list1);
        }
        if(list2!=null){
            temp.setDown(list2);
        }

        return result;
    }

    public NodeInt flattenList(NodeInt head){
        NodeInt list1 = null;
        NodeInt list2 = head;
        NodeInt temp = head;
        while(temp.getNext()!= null){
            list1 = list2;
            list2 = temp.getNext();
            temp = temp.getNext();
            list2 = mergeListUsingDownPointer(list1,list2);
        }
        return list2;
    }

    public static void main(String[] args) {
        MergeList merger = new MergeList();
        int[] arr1 = {5,7,9,20};
        int[] arr2 = {6,7,9,12,19,33};
        NodeInt list1 =  merger.createList(arr1);
        NodeInt list2 =  merger.createList(arr2);
        NodeInt mergedList = merger.mergeList(list1,list2);
        merger.printList(mergedList);
    }

    public NodeInt create2DListStructure(int[][] arr){
        NodeInt[] downPointers = new NodeInt[arr.length];
        for(int i=0;i<arr.length;i++){
            downPointers[i] = createListDownwards(arr[i]);
        }

        for(int i=0;i<downPointers.length-1;i++){
            downPointers[i].setNext(downPointers[i+1]);
        }
        return downPointers[0];
    }

    public NodeInt createList(int[] arr){
        NodeInt head = new NodeInt(arr[0]);
        NodeInt temp = head;

        for(int i=1;i<arr.length;i++){
            temp.setNext(new NodeInt(arr[i]));
            temp = temp.getNext();
        }
        return head;
    }

    public NodeInt createListDownwards(int[] arr){
        NodeInt head = new NodeInt(arr[0]);
        NodeInt temp = head;
        for(int i=1;i<arr.length;i++){
            temp.setDown(new NodeInt(arr[i]));
            temp = temp.getDown();
        }
        return head;
    }

    public void printList(NodeInt x){
        while(x!=null){
            System.out.print(x.getKey()+" ");
            x = x.getNext();
        }
    }
    public void printListUsingDownPointer(NodeInt x){
        while(x!=null){
            System.out.print(x.getKey()+" ");
            x = x.getDown();
        }
    }

    public void print2DList(NodeInt x){
        while(x!= null){
            NodeInt temp = x;
            System.out.println(" ");
            while (temp != null){
                System.out.print(temp.getKey()+" ");
                temp = temp.getDown();
            }
            x = x.getNext();
        }
    }
}
