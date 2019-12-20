package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class CloneTreeWithRandomPointerTest {

    @Test
    public void testCloneTreeOne() {
        CloneTreeWithRandomPointer clonner = new CloneTreeWithRandomPointer();
        RandomTreeNode input = clonner.createTernaryTree();
        RandomTreeNode output = clonner.cloneTree(input);
        clonner.printTree(input);
        System.out.println("\n Output Tree");
        clonner.printTree(output);
    }
}