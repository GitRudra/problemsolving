package org.home.ds.tree;

public class TreeNodeInt {
    TreeNodeInt left;
    TreeNodeInt right;
    int key;
    int data;
    int height;

    TreeNodeInt(int value){
        this.key = value;
        this.data = value;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public TreeNodeInt getLeft() {
        return left;
    }

    public void setLeft(TreeNodeInt left) {
        this.left = left;
    }

    public TreeNodeInt getRight() {
        return right;
    }

    public void setRight(TreeNodeInt right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int nodeValue) {
        this.key = nodeValue;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return key + " ";
    }
}
