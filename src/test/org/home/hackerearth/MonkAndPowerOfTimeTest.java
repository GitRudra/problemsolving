package org.home.hackerearth;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonkAndPowerOfTimeTest {

    @Test
    public void executionTimeOne() {
        Integer[] callingOrder = {3,2,1};
        Integer[] idealOrder = {1,3,2};

        int expectedTime = 5;
        int actualTime = MonkAndPowerOfTime.executionTime(callingOrder,idealOrder);
        assertEquals(expectedTime,actualTime);
    }
}