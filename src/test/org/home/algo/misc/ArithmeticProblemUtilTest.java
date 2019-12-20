package org.home.algo.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArithmeticProblemUtilTest {

    @Test
    public void testCalculatePow(){
        int x = 5;
        int y = 4;
        int expected = 625;
        int actual = ArithmeticProblemUtil.calculatePow(x,y);
        assertEquals(expected,actual);
    }

}