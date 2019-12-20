package org.home.ds.tree;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BoundaryOfABinaryTreeTest {

    @Test
    public void findBoundary() {
        TreeNodeInt tree = new TreeNodeInt(20);
        tree = new TreeNodeInt(20);
        tree.left = new TreeNodeInt(8);
        tree.left.left = new TreeNodeInt(4);
        tree.left.right = new TreeNodeInt(12);
        tree.left.right.left = new TreeNodeInt(10);
        tree.left.right.right = new TreeNodeInt(14);
        tree.right = new TreeNodeInt(22);
        tree.right.right = new TreeNodeInt(25);

        Integer[] expected = {20, 8, 4, 10, 14, 25, 22};
        BoundaryOfABinaryTree binaryTree = new BoundaryOfABinaryTree();
        List<Integer> resultList = binaryTree.findBoundary(tree);
        Integer[] actual = new Integer[resultList.size()];
        resultList.toArray(actual);
        assertArrayEquals(expected,actual);

    }
}