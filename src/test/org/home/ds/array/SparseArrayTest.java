package org.home.ds.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SparseArrayTest {

    @Test
    void matchingStringsTC001() {
        String[] strings = {"abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"};
        String[] queries = {"abcde", "sdaklfj", "asdjf", "na", "basdn"};
        int[] expected = {1,3,4,3,2};
        long start = System.currentTimeMillis();
        int[] actual = SparseArray.matchingStrings(strings,queries);
        long end = System.currentTimeMillis();
        System.out.println(" Execution Time TC001 = "+(end-start)+"ms");
        assertArrayEquals(expected,actual);
    }
}