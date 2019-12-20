package org.home.ds.tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class GcdOfGivenIndexRangeTest {

    @Test
    public void findGcdInTheRange() {
        int[] input = {2, 3, 6, 9, 5};
        GcdOfGivenIndexRange gcd = new GcdOfGivenIndexRange(input);
        int res = gcd.findGcdInTheRange(1,3);
        System.out.println(res);
    }
}