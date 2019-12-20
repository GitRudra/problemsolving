package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumPathSumTest {

    @Test
    public void testMinPathSumOne() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinimumPathSum solln = new MinimumPathSum();
        int expected = 7;
        int actual = solln.minPathSum(grid);
        assertEquals(expected,actual);

    }
}