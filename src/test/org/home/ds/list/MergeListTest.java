package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeListTest {

    @Test
    public void mergeList() {
        int[][] input = {{5,7,8,30},{2,4,6,9},{1,3,11,13}};
        MergeList merger = new MergeList();
        NodeInt head = merger.create2DListStructure(input);
        merger.print2DList(head);
        NodeInt result = merger.flattenList(head);
        merger.printListUsingDownPointer(result);
    }


}