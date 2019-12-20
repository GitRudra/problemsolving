package org.home.algo.misc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TappingRainWaterTest {

    @Test
    public void calculateWaterAmount() {
        TappingRainWater trw = new TappingRainWater();
        int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
        int expected = 6;
        int actual = trw.calculateWaterAmount(heights);
        assertEquals(expected,actual);
    }
}