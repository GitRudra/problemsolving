package org.home.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class DayOfAnYearTest {

    @Test
    public void dayOfYearOne() {
        String dateStr = "2019-01-09";
        int expected = 9;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
    @Test
    public void dayOfYearTwo() {
        String dateStr = "2019-02-10";
        int expected = 41;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
    @Test
    public void dayOfYearThree() {
        String dateStr = "2003-03-01";
        int expected = 60;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
    @Test
    public void dayOfYearFour() {
        String dateStr = "2004-03-01";
        int expected = 61;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
    @Test
    public void dayOfYearFive() {
        String dateStr = "2018-12-31";
        int expected = 365;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
    @Test
    public void dayOfYearSix() {
        String dateStr = "";
        int expected = -1;
        int actual = DayOfAnYear.dayOfYear(dateStr);
        assertEquals(expected,actual);
    }
}