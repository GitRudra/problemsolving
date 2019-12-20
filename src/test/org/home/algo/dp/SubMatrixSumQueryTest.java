package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class SubMatrixSumQueryTest {

    @Test
    public void testGetRangeSumQueryOne() {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};
        int row  = 4;
        int col = 5;
        SubMatrixSumQuery query = new SubMatrixSumQuery(mat,row,col);
        int sx = 2;
        int sy = 2;
        int tx = 3;
        int ty = 4;
        int expected = 38;
        int actual = query.getRangeSumQuery(sx,sy,tx,ty);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetRangeSumQueryTwo() {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};
        int row  = 4;
        int col = 5;
        SubMatrixSumQuery query = new SubMatrixSumQuery(mat,row,col);
        int sx = 0;
        int sy = 0;
        int tx = 1;
        int ty = 1;
        int expected = 11;
        int actual = query.getRangeSumQuery(sx,sy,tx,ty);
        assertEquals(expected,actual);
    }

    @Test
    public void testGetRangeSumQueryThree() {
        int mat[][] = {{1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}};
        int row  = 4;
        int col = 5;
        SubMatrixSumQuery query = new SubMatrixSumQuery(mat,row,col);
        int sx = 1;
        int sy = 2;
        int tx = 3;
        int ty = 3;
        int expected = 38;
        int actual = query.getRangeSumQuery(sx,sy,tx,ty);
        assertEquals(expected,actual);
    }


}