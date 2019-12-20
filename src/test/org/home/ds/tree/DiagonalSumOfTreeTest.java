package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiagonalSumOfTreeTest {

    @Test
    public void diagonalSumOfBinaryTreeOne() {
        TreeNodeInt root = new TreeNodeInt(7);
        root.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(5);
        root.left.left = new TreeNodeInt(3);
        root.right = new TreeNodeInt(11);
        root.right.left = new TreeNodeInt(9);
        root.right.right = new TreeNodeInt(17);
        DiagonalSumOfTree diagonalSum = new DiagonalSumOfTree();
        diagonalSum.diagonalSumOfBinaryTree(root);
    }

    @Test
    public void diagonalSumOfBinaryTreeTwo() {
        TreeNodeInt root = new TreeNodeInt(7);
        DiagonalSumOfTree diagonalSum = new DiagonalSumOfTree();
        diagonalSum.diagonalSumOfBinaryTree(root);
    }
}