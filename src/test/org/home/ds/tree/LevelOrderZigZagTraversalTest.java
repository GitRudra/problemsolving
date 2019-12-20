package org.home.ds.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LevelOrderZigZagTraversalTest {

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        List<List<Integer>> actual = LevelOrderZigZagTraversal.zigzagLevelOrder(root);
        actual.forEach(e-> System.out.println(e));
    }
}