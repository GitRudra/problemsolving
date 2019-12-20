package org.home.algo.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CircularGasStationTest {

    @Test
    public void canCompleteCircuit() {
        List<Integer> pumpCapacities = Arrays.asList(1,2);
        List<Integer> costs = Arrays.asList(2,1);
        int expected = 1;
        int actual = CircularGasStation.canCompleteCircuit(pumpCapacities,costs);
        assertEquals(expected,actual);

    }

    @Test
    public void canCompleteCircuitTwo() {
        List<Integer> pumpCapacities = Arrays.asList(383, 521, 491, 907, 871, 705);
        List<Integer> costs = Arrays.asList(96, 197, 592, 67, 77, 641);
        int expected = 0;
        int actual = CircularGasStation.canCompleteCircuit(pumpCapacities,costs);
        assertEquals(expected,actual);

    }
}