package org.home.ds.tree;

import org.junit.Test;

public class RangeMinimumQueryTest {

    @Test
    public void getSegmentTree() {
        int[] input = {-1,2,4,0};
        RangeMinimumQuery tree = new RangeMinimumQuery(input);
        /*int[] segTreeArr = tree.getSegmentTree();
        for(int x: segTreeArr){
            System.out.print(x+ " ");
        }*/
        System.out.println(tree.rangeQuery(1,3));
        System.out.println(tree.rangeQuery(0,3));
        System.out.println(tree.rangeQuery(1,4));
    }
}