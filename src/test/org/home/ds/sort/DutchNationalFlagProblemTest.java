package org.home.ds.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class DutchNationalFlagProblemTest {

    @Test
    public void testSortOne() {
        int[] input = {1,2,0,0,1,0,2,0,1};
        int[] expected = {0,0,0,0,1,1,1,2,2};
        DutchNationalFlagProblem solver = new DutchNationalFlagProblem();
        solver.sort(input);
        assertArrayEquals(expected,input);
    }

    @Test
    public void testSortTwo() {
        int[] input = {1,1,1,1,1,1,1,1,1,1};
        int[] expected = {1,1,1,1,1,1,1,1,1,1};
        DutchNationalFlagProblem solver = new DutchNationalFlagProblem();
        solver.sort(input);
        assertArrayEquals(expected,input);
    }
    @Test
    public void testSortThree() {
        int[] input = {2,2,2,2,2,2};
        int[] expected = {2,2,2,2,2,2};
        DutchNationalFlagProblem solver = new DutchNationalFlagProblem();
        solver.sort(input);
        assertArrayEquals(expected,input);
    }

    @Test
    public void testSortFour() {
        int[] input = {0,0,0,0,0,0,0};
        int[] expected = {0,0,0,0,0,0,0};
        DutchNationalFlagProblem solver = new DutchNationalFlagProblem();
        solver.sort(input);
        assertArrayEquals(expected,input);
    }
}