package org.home.algo.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class EggDroppingProblemsTest {

    @Test
    public void testDropEggRecOne() {
        int n = 2, k = 10;
        int expected = 4;
        int actual = EggDroppingProblems.eggDroppingIterative(n,k);
        assertEquals(expected,actual);
    }

    @Test
    public void testDropEggRecTwo() {
        int n = 2, k = 100;
        int expected = 14;
        int actual = EggDroppingProblems.eggDroppingIterative(n,k);
        assertEquals(expected,actual);
    }
}