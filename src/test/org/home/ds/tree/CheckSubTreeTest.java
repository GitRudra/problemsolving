package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckSubTreeTest {

    @Test
    public void testCheckSubTreeOne() {
        CheckSubTree check = new CheckSubTree();
        assertTrue(check.checkSubTreeOne(createSuperTreeOne(),createSubTreeOne()));
    }

    @Test
    public void testCheckSubTreeTwo() {
        CheckSubTree check = new CheckSubTree();
        assertFalse(check.checkSubTreeOne(createSuperTreeOne(),createSubTreeTwo()));
    }

    @Test
    public void testCheckSubTreeThree() {
        CheckSubTree check = new CheckSubTree();
        assertTrue(check.checkSubTreeTwo(createSuperTreeOne(), createSubTreeOne()));
    }

    @Test
    public void testCheckSubTreeFour() {
        CheckSubTree check = new CheckSubTree();
        assertFalse(check.checkSubTreeTwo(createSuperTreeOne(), createSubTreeTwo()));
    }

    /**
     *               A
     *             /   \
     *           B      C
     *         /  \     \
     *       D     E    F
     *        \
     *         G
     *
     *          B
     *         / \
     *       D    E
     *        \
     *         G
     * @return
     */
    private TreeNodeChar createSuperTreeOne(){
        TreeNodeChar root = new TreeNodeChar('A');
        root.setLeft(new TreeNodeChar('B'));
        root.setRight(new TreeNodeChar('C'));
        root.getLeft().setLeft(new TreeNodeChar('D'));
        root.getLeft().setRight(new TreeNodeChar('E'));
        root.getLeft().getLeft().setRight(new TreeNodeChar('G'));
        root.getRight().setRight(new TreeNodeChar('F'));
        return root;
    }

    private TreeNodeChar createSubTreeOne(){
        TreeNodeChar root = new TreeNodeChar('B');
        root.setLeft(new TreeNodeChar('D'));
        root.setRight(new TreeNodeChar('E'));
        root.getLeft().setRight(new TreeNodeChar('G'));
        return root;
    }

    private TreeNodeChar createSubTreeTwo(){
        TreeNodeChar root = new TreeNodeChar('B');
        root.setLeft(new TreeNodeChar('D'));
        root.setRight(new TreeNodeChar('F'));
        root.getLeft().setRight(new TreeNodeChar('G'));
        return root;
    }
}