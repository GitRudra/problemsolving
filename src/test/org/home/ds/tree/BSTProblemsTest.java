package org.home.ds.tree;

import org.junit.Test;
import static org.junit.Assert.*;

public class BSTProblemsTest {

    @Test
    public void findCeilOne() {
        TreeNodeInt root= createTree();
        BSTProblems solver = new BSTProblems();
        int key =13;
        int expected = 14;
        int actual = solver.findCeil(root,key);
        assertEquals(expected,actual);

    }

    @Test
    public void findCeilTwo() {
        TreeNodeInt root= createTree();
        BSTProblems solver = new BSTProblems();
        int key =17;
        int expected = Integer.MIN_VALUE;
        int actual = solver.findCeil(root,key);
        assertEquals(expected,actual);

    }

    @Test
    public void findFloorOne() {
        TreeNodeInt root= createTree();
        BSTProblems solver = new BSTProblems();
        int key =5;
        int expected = 4;
        int actual = solver.findFloor(root,key);
        assertEquals(expected,actual);

    }

    @Test
    public void testSortedArrayToBSTOne(){
        int[] input = {1,2,3,4,5};
        BSTProblems solver = new BSTProblems();
        TreeNodeInt root = solver.sortedArrayToBST(input);
        solver.printTree(root);
    }

    @Test
    public void testSortedArrayToBSTTwo(){
        int[] input = {1,2,3,4};
        BSTProblems solver = new BSTProblems();
        TreeNodeInt root = solver.sortedArrayToBST(input);
        solver.printTree(root);
    }

    @Test
    public void testUpdateBSTWithGreaterValueOne(){
        TreeNodeInt root = createTree();
        BSTProblems solver = new BSTProblems();
        solver.updateBSTWithGreaterValue(root);
        solver.printTree(root);

    }

    private TreeNodeInt createTree(){
        TreeNodeInt tree = new TreeNodeInt(8);
        tree.setLeft(new TreeNodeInt(4));
        tree.setRight(new TreeNodeInt(12));
        tree.getLeft().setLeft(new TreeNodeInt(2));
        tree.getLeft().setRight(new TreeNodeInt(6));
        tree.getRight().setLeft(new TreeNodeInt(10));
        tree.getRight().setRight(new TreeNodeInt(14));
        return  tree;
    }
}