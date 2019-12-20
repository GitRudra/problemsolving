package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    @Test
    public void testFindLCAOne() {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        int expected = 2;
        int key1 = 3;
        int key2 = 4;

        int actual = lcaFinder.findLCA(createTreeOne(),key1,key2);
        assertEquals(expected,actual);

    }
    @Test
    public void testFindLCATwo() {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        int expected = 1;
        int key1 = 8;
        int key2 = 9;

        int actual = lcaFinder.findLCA(createTreeOne(),key1,key2);
        assertEquals(expected,actual);

    }
    @Test
    public void testFindLCAThree() {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        int expected = 8;
        int key1 = 8;
        int key2 = 8;

        int actual = lcaFinder.findLCA(createTreeOne(),key1,key2);
        assertEquals(expected,actual);

    }
    @Test
    public void testFindLCAFour() {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        int expected = LowestCommonAncestor.NOT_FOUND;
        int key1 = 8;
        int key2 = 18;

        int actual = lcaFinder.findLCA(createTreeOne(),key1,key2);
        assertEquals(expected,actual);

    }
    @Test
    public void testFindLCAFive() {
        LowestCommonAncestor lcaFinder = new LowestCommonAncestor();
        int expected = LowestCommonAncestor.NOT_FOUND;
        int key1 = 18;
        int key2 = 8;

        int actual = lcaFinder.findLCA(createTreeOne(),key1,key2);
        assertEquals(expected,actual);

    }


    private TreeNodeInt createTreeOne(){

        TreeNodeInt root  = new TreeNodeInt(1);
        root.left = new TreeNodeInt(2);
        root.left.left = new TreeNodeInt(3);
        root.left.right = new TreeNodeInt(4);
        root.left.right.left = new TreeNodeInt(8);
        root.right = new TreeNodeInt(5);
        root.right.left = new TreeNodeInt(6);
        root.right.left.right = new TreeNodeInt(9);
        root.right.right = new TreeNodeInt(7);

        return root;
    }
}