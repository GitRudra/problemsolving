package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestBSTInBinaryTreeTest {

    @Test
    public void largestBst() {
        LargestBSTInBinaryTree sol = new LargestBSTInBinaryTree();
        int expected = 8;
        int actual = sol.largestBst(createTree());
        assertEquals(expected,actual);
    }

    private TreeNode createTree(){
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(18);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(19);
        root.left.left.right = new TreeNode(15);

        root.left.right = new TreeNode(20);
        root.left.right.left = new TreeNode(18);
        root.left.right.right = new TreeNode(25);

        root.right.left = new TreeNode(35);
        root.right.left.left = new TreeNode(20);
        root.right.left.left.right = new TreeNode(25);
        root.right.left.right = new TreeNode(40);

        root.right.right = new TreeNode(60);
        root.right.right.left = new TreeNode(55);
        root.right.right.right = new TreeNode(70);
        return root;
    }
}