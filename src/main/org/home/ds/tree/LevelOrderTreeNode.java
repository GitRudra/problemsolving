package org.home.ds.tree;

public class LevelOrderTreeNode {
    int value;
    LevelOrderTreeNode left;
    LevelOrderTreeNode right;
    LevelOrderTreeNode nextPtr;

    public LevelOrderTreeNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "LevelOrderTreeNode{" +
                "value=" + value +
                ", left=" + (left==null?"-":left.value) +
                ", right=" + (right==null?"-":right.value) +
                ", nextPtr=" + (nextPtr==null?"|":nextPtr.value) +
                '}';
    }
}
