package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SummationOnTreeTest {

    @Test
    public void sumOfNodesInBottomViewOfTreeOne() {
        SummationOnTree actor = new SummationOnTree();
        int[] input = {1,2,3,4,5,0,6};
        int expected = 20;
        TreeNodeInt root = actor.createTree(input);
        Integer actual = actor.sumOfNodesInBottomViewOfTree(root);
        assertEquals(expected,actual.intValue());
    }

    @Test
    public void sumOfNodesInBottomViewOfTreeTwo() {
        SummationOnTree actor = new SummationOnTree();
        int expected = 17;
        TreeNodeInt root = createTree();
        Integer actual = actor.sumOfNodesInBottomViewOfTree(root);
        assertEquals(expected,actual.intValue());
    }

    private TreeNodeInt createTree(){
        TreeNodeInt root = new TreeNodeInt(1);
        root.setLeft(new TreeNodeInt(2));
        root.setRight(new TreeNodeInt(3));
        root.getLeft().setRight(new TreeNodeInt(4));
        root.getLeft().getRight().setRight(new TreeNodeInt(5));
        root.getLeft().getRight().getRight().setRight(new TreeNodeInt(6));
        return root;
    }
}