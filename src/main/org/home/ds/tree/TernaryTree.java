package org.home.ds.tree;

public class TernaryTree {

    public TernaryTreeNode createTernaryTree(){
        TernaryTreeNode root = new TernaryTreeNode(30);
        root.setLeft(new TernaryTreeNode(5));
        root.setMiddle(new TernaryTreeNode(11));
        root.setRight(new TernaryTreeNode(63));
        root.getLeft().setLeft(new TernaryTreeNode(1));
        root.getLeft().setMiddle(new TernaryTreeNode(4));
        root.getLeft().setRight(new TernaryTreeNode(8));
        return root;
    }

}
