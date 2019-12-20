package org.home.algo.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class NaviePatternMatcherTest {

    @Test
    public void findFirstIndexOfBothEmptyString() {
        NaviePatternMatcher matcher = new NaviePatternMatcher();
        String inputString = "";
        String searchPattern = "";
        int expected = -1;
        int actual = matcher.findFirstIndexOf(inputString,searchPattern);
        assertEquals(expected,actual);

    }

    @Test
    public void findFirstIndexOfSuccessOne() {
        NaviePatternMatcher matcher = new NaviePatternMatcher();
        String inputString = "AABAACAADAABAAABAA";
        String searchPattern = "AABA";
        int expected = 0;
        int actual = matcher.findFirstIndexOf(inputString,searchPattern);
        assertEquals(expected,actual);

    }

    @Test
    public void findFirstIndexOfSuccessTwo() {
        NaviePatternMatcher matcher = new NaviePatternMatcher();
        String inputString = "ATA";
        String searchPattern = "TA";
        int expected = 1;
        int actual = matcher.findFirstIndexOf(inputString,searchPattern);
        assertEquals(expected,actual);

    }

    @Test
    public void findFirstIndexOfSuccessThree() {
        NaviePatternMatcher matcher = new NaviePatternMatcher();
        String inputString = "ATA";
        String searchPattern = "BA";
        int expected = -1;
        int actual = matcher.findFirstIndexOf(inputString,searchPattern);
        assertEquals(expected,actual);

    }
}