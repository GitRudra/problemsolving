package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheckBSTTest {

    @Test
    public void checkBSTOne() {
        TreeNodeInt root = new TreeNodeInt(7);
        root.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(3);
        root.right = new TreeNodeInt(11);
        root.right.left = new TreeNodeInt(9);
        root.right.right = new TreeNodeInt(17);
        CheckBST bstChecker = new CheckBST();
        assertTrue(bstChecker.checkBST(root));

    }

    @Test
    public void checkBSTTwo() {
        TreeNodeInt root = new TreeNodeInt(7);
        root.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(3);
        root.right = new TreeNodeInt(11);
        root.right.left = new TreeNodeInt(9);
        CheckBST bstChecker = new CheckBST();
        assertTrue(bstChecker.checkBST(root));

    }

    @Test
    public void checkBSTThree() {
        TreeNodeInt root = new TreeNodeInt(7);
        root.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(13);
        root.right = new TreeNodeInt(11);
        root.right.left = new TreeNodeInt(9);
        CheckBST bstChecker = new CheckBST();
        assertFalse(bstChecker.checkBST(root));

    }
}