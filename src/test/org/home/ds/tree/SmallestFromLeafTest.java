package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestFromLeafTest {

    @Test
    public void smallestFromLeafOne() {
        //[2,2,1,null,1,0,null,0]
        //[
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);
        root.left.left = null;
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = null;
        root.left.right.left = new TreeNode(0);
        SmallestFromLeaf obj = new SmallestFromLeaf();
        String expected = "abc";
        String actual = obj.smallestFromLeaf(root);
        assertEquals(expected,actual);
    }

    @Test
    public void smallestFromLeafTwo() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);

        String expected = "bae";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        String actual = obj.smallestFromLeaf(root);
        assertEquals(expected,actual);
    }


    /*public void smallestFromLeafThree() {
        //[[4,0,1,1]]
        //[e,a,b,b]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);

        String expected = "bae";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        String actual = obj.smallestFromLeaf(root);
        assertEquals(expected,actual);
    }*/
    @Test
    public void testIsPrefixOne(){
        String s1 = "abc";
        String s2 = "ab";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        //System.out.println(s1.compareTo("abcc"));
        assertTrue(obj.isPrefix(s1,s2));
    }

    @Test
    public void testIsPrefixTwo(){
        String s1 = "abc";
        String s2 = "abcd";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        assertFalse(obj.isPrefix(s1,s2));
    }

    @Test
    public void testCompareStringOne(){
        String s1 = "abc";
        String s2 = "ab";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        String expected = "abc";
        String actual = obj.getSmallerString(s1,s2);
        assertEquals(expected,actual);
    }

    @Test
    public void testCompareStringTwo(){
        String s1 = "abc";
        String s2 = "dba";
        SmallestFromLeaf obj = new SmallestFromLeaf();
        String expected = "abc";
        String actual = obj.getSmallerString(s1,s2);
        assertEquals(expected,actual);
    }
}