package org.home.ds.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeQueryTest {

    @Test
    public void findMaxQueryLength1() {
        String inputString = "()(())())";
        RangeQuery rq = new RangeQuery();
        int expected = 8;
        int actual = rq.findMaxQueryLength(inputString);
        assertEquals(expected,actual);
    }

    @Test
    public void findMaxQueryLength2() {
        String inputString = "())())()()";
        RangeQuery rq = new RangeQuery();
        int expected = 4;
        int actual = rq.findMaxQueryLength(inputString);
        assertEquals(expected,actual);
    }

    @Test
    public void findMaxQueryLength3() {
        String inputString = "))))";
        RangeQuery rq = new RangeQuery();
        int expected = 0;
        int actual = rq.findMaxQueryLength(inputString);
        assertEquals(expected,actual);
    }

    @Test
    public void findMaxQueryLength4() {
        String inputString = "(((((";
        RangeQuery rq = new RangeQuery();
        int expected = 0;
        int actual = rq.findMaxQueryLength(inputString);
        assertEquals(expected,actual);
    }
}