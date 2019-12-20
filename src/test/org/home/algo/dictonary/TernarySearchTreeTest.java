package org.home.algo.dictonary;

import org.junit.Test;

import static org.junit.Assert.*;

public class TernarySearchTreeTest {

    @Test
    public void testInsertOne() {
        TernarySearchTree tree = new TernarySearchTree();
        tree.insert("cat");
        tree.insert("cow");
        tree.insert("cup");
        assertTrue(tree.search("cow"));
    }

    @Test
    public void search() {
    }
}