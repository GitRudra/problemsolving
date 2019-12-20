package org.home.algo.online;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfRunningStreamOfIntegerTest {

    @Test
    public void testGetEffectiveMedianOne() throws Exception {
        int HEAP_SIZE = 999;
        MedianOfRunningStreamOfInteger stream = new MedianOfRunningStreamOfInteger(HEAP_SIZE);
        int[] input = {11,9,22,55,44,33,3,21,8};
        int effectiveMedian = 0;
        for(int i=0;i<input.length;i++){
            effectiveMedian = stream.getEffectiveMedian(input[i],effectiveMedian);
            System.out.println("Effective Median : "+effectiveMedian);
        }
    }
}