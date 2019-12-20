package org.home.ds.tree;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class LevelOrderTraversalTest {

    @Test
    public void printLevelOrderTraversal() {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        ArrayList<Integer> result = traversal.printLevelOrderTraversal(createTree());
        if (result != null) {
            result.forEach(e -> System.out.print(e + " "));
        }
    }

    @Test
    public void testLinkTreeNodeOne() {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        LevelOrderTreeNode root = createTree();
        traversal.linkTreeNode(root);
        traversal.printTree(root);
    }

    @Test
    public void testPrintZigZag() {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        LevelOrderTreeNode root = createTree();
        traversal.printSpiral(root);
        //traversal.printTree(root);
    }

    @Test
    public void testFindAlternateLevelSumDifference() {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        LevelOrderTreeNode root = createTreeTwo();
        int expected = 18;
        int actual = traversal.findAlternateLevelSumDifference(root);
        assertEquals(expected,actual);
        //traversal.printSpiral(root);
        //traversal.printTree(root);
    }


    @Test
    public void testGetLevelDiff() {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        LevelOrderTreeNode root = createTreeTwo();
        int expected = 18;
        int actual = traversal.getLevelDiff(root);
        assertEquals(expected,actual);
        //traversal.printSpiral(root);
        //traversal.printTree(root);
    }

    private LevelOrderTreeNode createTree() {
        LevelOrderTreeNode root = new LevelOrderTreeNode(1);
        root.left = new LevelOrderTreeNode(2);
        root.right = new LevelOrderTreeNode(3);
        root.left.left = new LevelOrderTreeNode(4);
        root.left.right = new LevelOrderTreeNode(5);
        root.right.left = new LevelOrderTreeNode(6);
        root.right.right = new LevelOrderTreeNode(7);
        root.left.left.left = new LevelOrderTreeNode(8);
        root.left.left.right = new LevelOrderTreeNode(9);
        root.left.right.right = new LevelOrderTreeNode(10);
        root.left.right.right.right = new LevelOrderTreeNode(11);
        return root;
    }

    private LevelOrderTreeNode createTreeTwo() {
        LevelOrderTreeNode root = new LevelOrderTreeNode(1);
        root.left = new LevelOrderTreeNode(2);
        root.right = new LevelOrderTreeNode(3);
        root.left.left = new LevelOrderTreeNode(4);
        root.left.right = new LevelOrderTreeNode(5);
        root.right.left = new LevelOrderTreeNode(6);
        root.right.right = new LevelOrderTreeNode(7);
        /*root.left.left.left = new LevelOrderTreeNode(8);
        root.left.left.right = new LevelOrderTreeNode(9);
        root.left.right.right = new LevelOrderTreeNode(10);
        root.left.right.right.right = new LevelOrderTreeNode(11);*/
        return root;
    }
}