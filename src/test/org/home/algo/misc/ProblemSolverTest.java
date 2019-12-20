package org.home.algo.misc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProblemSolverTest {
    ProblemSolver solver;
    @Before
    public void setUp() throws Exception {
        solver = new ProblemSolver();
    }

    @Test
    public void findAngleBetweenHourAndMinuteHand1() {
        int hour = 3;
        int min = 30;
        int expected = 75;
        int actual = solver.findAngleBetweenHourAndMinuteHand(hour,min);
        assertEquals(expected,actual);
    }

    @Test
    public void findAngleBetweenHourAndMinuteHand2() {
        int hour = 9;
        int min = 60;
        int expected = 90;
        int actual = solver.findAngleBetweenHourAndMinuteHand(hour,min);
        assertEquals(expected,actual);
    }

    @Test
    public void testCountNumberOfEvenNumbers1() {
        String input = "574674546476";
        int[] expected = {7, 7, 7, 6, 5, 5, 4, 4, 3, 2, 1, 1};
        int[] actual = solver.countNumberOfEvenNumbers(input);
        assertArrayEquals(expected,actual);
    }
}