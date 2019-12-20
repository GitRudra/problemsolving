package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class SetMatrixZeroTest {

    @Test
    public void testSetZeroesOne() {
        int row = 3;
        int[][] input = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        int [][] expected = {{1,0,1},{0,0,0},{1,0,1}};
        SetMatrixZero sol = new SetMatrixZero();
        sol.setZeroes(input);
        assertArrayEquals("Oth Row",expected[0],input[0]);
        assertArrayEquals("1st Row",expected[1],input[1]);
        assertArrayEquals("2nd Row",expected[2],input[2]);
    }

    @Test
    public void testSetZeroesTwo() {
        int row = 3;
        int[][] input = {{-1},{2},{3}};
        int [][] expected = {{-1},{2},{3}};
        SetMatrixZero sol = new SetMatrixZero();
        sol.setZeroes(input);
        assertArrayEquals("Oth Row",expected[0],input[0]);
        assertArrayEquals("1st Row",expected[1],input[1]);
        assertArrayEquals("2nd Row",expected[2],input[2]);
    }



    @Test
    public void testSetZeroesThree() {
        int row = 3;
        int[][] input = {{-4,-2147483648,6,-7,0},
                         {-8,6,-8,-6,0},
                      {2147483647,2,-9,-6,-10}};
        int [][] expected = {{0,0,0,0,0},{0,0,0,0,0},{2147483647,2,-9,-6,0}};
        SetMatrixZero sol = new SetMatrixZero();
        sol.setZeroes(input);
        assertArrayEquals("Oth Row",expected[0],input[0]);
        assertArrayEquals("1st Row",expected[1],input[1]);
        assertArrayEquals("2nd Row",expected[2],input[2]);
    }
}