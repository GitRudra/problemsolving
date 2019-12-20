package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncesterOfBSTTest {

    @Test
    public void getLCABST() {
        int key1 = 14;
        int key2 = 8;
        LowestCommonAncesterOfBST executor = new LowestCommonAncesterOfBST();
        TreeNodeInt lca = executor.getLCABST(createTreeOne(),key1,key2);
        int expected = 8;
        assertEquals(expected,lca.key);

    }

    private TreeNodeInt createTreeOne(){

        TreeNodeInt root  = new TreeNodeInt(20);
        root.left = new TreeNodeInt(8);
        root.left.left = new TreeNodeInt(4);
        root.left.right = new TreeNodeInt(12);
        root.left.right.left = new TreeNodeInt(10);
        root.left.right.right = new TreeNodeInt(14);
        root.right = new TreeNodeInt(22);
        /*root.right.left = new TreeNodeInt(6);
        root.right.left.right = new TreeNodeInt(9);
        root.right.right = new TreeNodeInt(7);*/

        return root;
    }
}