package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestBadVersionTest {

    @Test
    public void firstBadVersionOne() {
        boolean[] versionArray = {false,false,false,true,true};
        TestBadVersion versionTester = new TestBadVersion(versionArray);
        int expected = 4;
        int actual = versionTester.firstBadVersion(5);
        assertEquals(expected,actual);
    }

    @Test
    public void firstBadVersionTwo() {
        boolean[] versionArray = {false,false,false,false,true};
        TestBadVersion versionTester = new TestBadVersion(versionArray);
        int expected = 5;
        int actual = versionTester.firstBadVersion(5);
        assertEquals(expected,actual);
    }
}