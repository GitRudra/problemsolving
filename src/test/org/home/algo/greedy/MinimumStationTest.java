package org.home.algo.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumStationTest {

    @Test
    public void findMinimumStationOne() {
        int[] arrivals = {900, 940, 950, 1100, 1500, 1800};
        int[] departures = {910, 1200, 1120, 1130, 1900, 2000};

        MinimumStation station = new MinimumStation();
        int expected = 3;
        int actual = station.findMinimumStation(arrivals,departures);
        assertEquals(expected,actual);

    }
}