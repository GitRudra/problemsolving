package org.home.ds.tree;

public class TreeNodeChar {

    private TreeNodeChar left;
    private TreeNodeChar right;
    private char key;

    public TreeNodeChar() {
    }

    public TreeNodeChar(char key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public TreeNodeChar getLeft() {
        return left;
    }

    public void setLeft(TreeNodeChar left) {
        this.left = left;
    }

    public TreeNodeChar getRight() {
        return right;
    }

    public void setRight(TreeNodeChar right) {
        this.right = right;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }
}
