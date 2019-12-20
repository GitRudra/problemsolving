package org.home.ds.list;

public class CloneLinkedList<E> {
    class Node<E>{
        E value;
        Node next;
        Node random;

        public Node(E value) {
            this.value = value;
            this.next = null;
            this.random = null;
        }

        public E getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getRandom() {
            return random;
        }

        @Override
        public String toString() {
            return "LevelOrderTreeNode{" +
                    "value=" + value +
                    ", next=" + (next == null?"null":next.value) +
                    ", random=" + (random == null ? "null" : random.value)+
                    '}';
        }
    }

    private Node getNewNode(E value){
        return new Node(value);
    }

    public Node<E> cloneList(Node head){
        if(head == null){
            return null;
        }else{
            Node sHead = head;
            while(sHead != null){
                Node temp = new Node(sHead.getValue());
                temp.next = sHead.next;
                sHead.next = temp;
                sHead = sHead.getNext().getNext();
            }

            sHead = head;

            while(sHead != null){
                if(sHead.random != null){
                    sHead.next.random = sHead.random.next;
                }
                sHead = sHead.next.next;
            }
            sHead = head;
            Node dHead = head.next;
            Node clonedListHead = dHead;
            while(sHead != null){
                sHead.next = dHead.next;
                if(dHead.next!=null){
                    dHead.next = dHead.next.next;
                    dHead = dHead.next;
                }
                sHead = sHead.next;
            }
            return clonedListHead;
        }

    }

    public void print(Node h){
        while(h!=null){
            System.out.println(h);
            h=h.next;
        }
    }

    public Node createList(){
        Node<Integer> h = new Node(1);
        Node<Integer> head = h;
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(5);
        h.next.next.next.next.next = new Node(6);
        h.random = h.next.next;
        h.next.random = h.next.next.next;
        return h;
    }

    public static void main(String[] args) {
        CloneLinkedList<Integer> cloneLinkedList = new CloneLinkedList<>();
        cloneLinkedList.execute();

    }

    private void execute(){
        Node source = createList();
        long start = System.nanoTime();
        Node clone  = cloneList(source);
        long end = System.nanoTime();
        System.out.println(" Execution time : "+(end-start)+"ns");
        /*System.out.println(" Printing Source List");
        print(source);
        System.out.println("\n Printing Cloned List");
        print(clone);*/
    }
}
