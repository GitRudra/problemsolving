package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class CousinFinderTest {

    @Test
    public void printCousinNode() {
        TreeNodeInt root = createTreeOne();
        int targetNode = 5;
        CousinFinder.printCousinNode(root,targetNode);
    }

    @Test
    public void printCousinNodeTwo() {
        TreeNodeInt root = createTreeOne();
        int targetNode = 4;
        CousinFinder.printCousinNode(root,targetNode);
    }

    @Test
    public void printCousinNodeThree() {
        TreeNodeInt root = createTreeOne();
        int targetNode = 4;
        CousinFinder.printCousinNodeLevelOrder(root,targetNode);
    }

    private TreeNodeInt createTreeOne(){

        TreeNodeInt root  = new TreeNodeInt(1);
        root.left = new TreeNodeInt(2);
        root.left.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.right = new TreeNodeInt(3);
        root.right.left = new TreeNodeInt(6);
        root.right.right = new TreeNodeInt(7);
        return root;
    }
}