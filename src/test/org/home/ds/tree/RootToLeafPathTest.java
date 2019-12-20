package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class RootToLeafPathTest {

    @Test
    public void checkOne() {
        TreeNodeInt root = createTree();
        int[] pathArray = {5, 2, 4, 8};
        assertTrue(RootToLeafPath.check(root,pathArray));
    }

    @Test
    public void checkTwo() {
        TreeNodeInt root = createTree();
        int[] pathArray = {5, 3, 4, 9};
        assertFalse(RootToLeafPath.check(root,pathArray));
    }

    private TreeNodeInt createTree(){
        TreeNodeInt root  = new TreeNodeInt(5);
        root.left = new TreeNodeInt(2);
        root.left.left = new TreeNodeInt(1);
        root.left.right = new TreeNodeInt(4);
        root.left.right.left = new TreeNodeInt(6);
        root.left.right.right = new TreeNodeInt(8);
        root.right = new TreeNodeInt(3);
        /*root.right.left = new TreeNodeInt(6);
        root.right.right = new TreeNodeInt(7);*/
        return root;
    }
}