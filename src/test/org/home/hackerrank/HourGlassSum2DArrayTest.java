package org.home.hackerrank;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HourGlassSum2DArrayTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateMaxSumOne() throws Exception {
        int[][] input = {{1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}};
        int expected = 19;
        int actual = HourGlassSum2DArray.calculateMaxSum(input);
        assertEquals(expected,actual);
    }

    @Test
    public void calculateMaxSumTwo() throws Exception {
        int[][] input = {{-9, -9, -9,  1, 1, 1 },
                { 0, -9,  0,  4, 3, 2},
                {-9, -9, -9,  1, 2, 3},
                { 0,  0,  8,  6, 6, 0},
                { 0,  0,  0, -2, 0, 0},
                { 0,  0,  1,  2, 4, 0}};
        int expected = 28;
        int actual = HourGlassSum2DArray.calculateMaxSum(input);
        assertEquals(expected,actual);
    }
}