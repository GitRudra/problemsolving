package org.home.ds.list;

public class SpecialListStructure {
    class Node {
        Node next;
        Node down;
        Integer key;

        public Node(Integer key) {
            this.key = key;
            next = null;
            down = null;
        }
    }

    private Node HEAD;
    private Integer COLUMN_SIZE;

    public SpecialListStructure(Integer columnSize) {
        HEAD = null;
        COLUMN_SIZE = columnSize;
    }


    public void createList(int[][] input, int row, int column) {
        HEAD = new Node(input[0][0]);
        Node rowHead = HEAD;
        Node rowTemp = HEAD;
        for (int j = 1; j < column; j++) {
            rowTemp.next = new Node(input[0][j]);
            rowTemp = rowTemp.next;
        }
        for (int i = 1; i < row; i++) {
            Node rTemp = new Node(input[i][0]);
            rowHead.down = rTemp;
            rowHead = rTemp;
            for (int j = 1; j < column; j++) {
                rTemp.next = new Node(input[i][j]);
                rTemp = rTemp.next;
            }
        }

        return;
    }

    public void printList() {
        Node columnPointer = HEAD;
        // LevelOrderTreeNode rowPointer = HEAD;
        while (columnPointer != null) {
            Node rowPointer = columnPointer;
            while (rowPointer != null) {
                if (rowPointer.next == null) {
                    System.out.print(rowPointer.key);
                } else {
                    System.out.print(rowPointer.key + " -> ");
                }

                rowPointer = rowPointer.next;
            }

            columnPointer = columnPointer.down;
            //HEAD = columnPointer;
            System.out.println();
        }
    }

    public void insert(Integer key) {
        Node keyNode = new Node(key);
        Node rHead = HEAD;
        Node rHeadSlow = HEAD;
        Node rPointer;
        Node rPointerFast;
        boolean recordInserted = false;
        while (rHead != null) {
            rPointer = rHead;
            rPointerFast = rHead.next;
            if (key < rHead.key) {
                keyNode.next = rHead;
                keyNode.down = rHead.down;
                rHead.down = null;
                if(rHead==HEAD){
                    HEAD = keyNode;
                }
                rHead = keyNode;
                rHeadSlow.down = keyNode;
                reArrangeListAfterInsert(rHead);
                break;
            } else {
                while (rPointerFast != null) {
                    if (rPointer.key <= key && rPointerFast.key > key) {
                        keyNode.next = rPointer.next;
                        rPointer.next = keyNode;
                        reArrangeListAfterInsert(rHead);
                        recordInserted = true;
                        break;
                    }
                    rPointerFast = rPointerFast.next;
                    rPointer = rPointer.next;
                }
            }

            if (recordInserted) {
                break;
            }
            rHeadSlow = rHead;
            rHead = rHead.down;
        }

    }

    private void reArrangeListAfterInsert(Node startHead) {
        Node tHead = startHead;
        int counter;
        while (tHead != null) {
            Node tRowPtr = tHead;
            counter = COLUMN_SIZE;
            while (counter > 1 && tRowPtr != null) {
                tRowPtr = tRowPtr.next;
                counter--;
            }
            if (tRowPtr == null) {
                return;
            }
            if (tRowPtr.next == null) {
                return;
            } else {
                Node t = tRowPtr.next;
                tRowPtr.next = null;
                t.next = tHead.down;
                if (tHead.down == null) {
                    t.down = null;
                } else {
                    t.down = tHead.down.down;
                }
                tHead.down = t;
                tHead = tHead.down;
            }
        }
        /*final ArrayList<LevelOrderTreeNode> x = new ArrayList();
        x.add(new LevelOrderTreeNode(1));
        x.add(new LevelOrderTreeNode(2));
        x.get(0).key = 3;*/
    }


    private void reArrangeListAfterDelete(Node rHead){
        if(rHead.down==null){
            return;
        }
        Node rPointer;
        while(rHead!=null){
            rPointer = rHead;
            while(rPointer.next != null){
                rPointer = rPointer.next;
            }
            rPointer.next = rHead.down;
            rHead.down.next.down = rHead.down.down;
            rHead.down = rHead.down.next;
            rPointer.next.next = null;
            rHead = rHead.down;
        }
    }
}
