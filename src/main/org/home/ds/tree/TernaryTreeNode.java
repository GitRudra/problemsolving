package org.home.ds.tree;

public class TernaryTreeNode{
    int value;
    TernaryTreeNode left;
    TernaryTreeNode right;
    TernaryTreeNode middle;

    public TernaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.middle = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TernaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(TernaryTreeNode left) {
        this.left = left;
    }

    public TernaryTreeNode getRight() {
        return right;
    }

    public void setRight(TernaryTreeNode right) {
        this.right = right;
    }

    public TernaryTreeNode getMiddle() {
        return middle;
    }

    public void setMiddle(TernaryTreeNode middle) {
        this.middle = middle;
    }
}
