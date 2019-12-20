package org.home.hackerrank.secai;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMaxDifferenceTest {

    @Test
    public void maxDifferenceOne() {
        List<Integer> input = Arrays.asList(2,3,10,2,4,8,1);
        int expected = 8;
        int actual = SimpleMaxDifference.maxDifferenceTwo(input);
        assertEquals(expected,actual);
    }

    @Test
    public void maxDifferenceTwo() {
        List<Integer> input = Arrays.asList(10,8,6,4,2);
        int expected = -1;
        int actual = SimpleMaxDifference.maxDifferenceTwo(input);
        assertEquals(expected,actual);
    }
}