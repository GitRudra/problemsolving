package org.home.hackerrank;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BirthdayCandleOrganizerTest {

    @Test
    public void birthdayCakeCandlesOne() {
        int[] candles = {3, 2, 1, 3};
        int expected = 2;
        int actual = BirthdayCandleOrganizer.birthdayCakeCandles(candles);
        assertEquals(expected, actual);
    }

    @Test
    public void birthdayCakeCandlesTwo() {
        int[] candles = {4, 4, 1, 2};
        int expected = 2;
        int actual = BirthdayCandleOrganizer.birthdayCakeCandles(candles);
        assertEquals(expected, actual);
    }

    @Test
    public void birthdayCakeCandlesThree() {
        int[] candles = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int expected = 1;
        int actual = BirthdayCandleOrganizer.birthdayCakeCandles(candles);
        assertEquals(expected, actual);
    }

}