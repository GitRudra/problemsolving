package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class RootToLeafPathPrinterTest {

    @Test
    public void printPathOne() {
        TreeNodeInt root = createTree();
        RootToLeafPathPrinter printer = new RootToLeafPathPrinter();
        printer.printPath(root);
    }

    @Test
    public void printPathTwo() {
        TreeNodeInt root = createTree();
        RootToLeafPathPrinter printer = new RootToLeafPathPrinter();
        printer.printRootToLeafPathIterative(root);
    }

    private TreeNodeInt createTree(){
        TreeNodeInt root = new TreeNodeInt(7);
        root.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(3);
        root.right = new TreeNodeInt(11);
        root.right.left = new TreeNodeInt(9);
        root.right.right = new TreeNodeInt(17);
        return root;
    }
}