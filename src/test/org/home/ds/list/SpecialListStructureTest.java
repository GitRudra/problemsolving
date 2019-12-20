package org.home.ds.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpecialListStructureTest {

    @Test
    public void createTree() {
    }

    @Test
    public void printList() {
    }

    @Test
    public void testCreateList() {
        int[][] input =
                {{1, 2, 3, 4},
                {5, 7, 9, 11},
                {13, 15, 17, 19},
                {21, 22, 24, 28}};

        SpecialListStructure list = new SpecialListStructure(4);
        list.createList(input,4,4);
        //list.printList();
        list.insert(0);
        list.insert(-1);
        list.insert(20);
        list.insert(6);
        list.insert(10);
        list.printList();
    }

}