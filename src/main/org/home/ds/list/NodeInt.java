package org.home.ds.list;

public class NodeInt {
    private int key;
    private NodeInt next;
    private NodeInt down;

    public NodeInt(int key) {
        this.key = key;
        next = null;
        down = null;
    }

    public int getKey() {
        return key;
    }

    public NodeInt getNext() {
        return next;
    }

    public NodeInt getDown() {
        return down;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setNext(NodeInt next) {
        this.next = next;
    }

    public void setDown(NodeInt down) {
        this.down = down;
    }
}
