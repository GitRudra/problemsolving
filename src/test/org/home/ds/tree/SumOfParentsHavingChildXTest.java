package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfParentsHavingChildXTest {

    @Test
    public void getSumOne() {
        SumOfParentsHavingChildX actor = new SumOfParentsHavingChildX();
        int[] input = {4,2,5,7,2,2,3};
        int key = 2;
        int expected = 11;
        TreeNodeInt root = actor.createTree(input);
        actor.displayTree(root);
        Integer actual = actor.getSum(root,key);
        assertEquals(expected,actual.intValue());
    }
}