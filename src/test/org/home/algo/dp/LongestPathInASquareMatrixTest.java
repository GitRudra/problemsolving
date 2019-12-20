package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestPathInASquareMatrixTest {

    @Test
    public void findLongestPathInSquareMatrix() {
        int  mat[][] = { {1, 2, 9},
                {5, 3, 8},
                {4, 6, 7} };
        int n = 3;

        int expected = 4;
        int actual = LongestPathInASquareMatrix.findLongestPathInSquareMatrix(mat,n);
        assertEquals(expected,actual);
    }
}