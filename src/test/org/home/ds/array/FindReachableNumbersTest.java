package org.home.ds.array;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindReachableNumbersTest {

    @Test
    public void findReachableNumbersOne() {
        int[] inputArray={10,15,20};
        int[] expectedArray={1,0,1};
        int start = 10;
        int d1=4;
        int d2=6;
        FindReachableNumbers numbers = new FindReachableNumbers();
        assertArrayEquals(expectedArray,numbers.findReachableNumbers(inputArray,start,d1,d2));
    }
    @Test
    public void findReachableNumbersTwo() {
        int[] inputArray={10,15,20};
        int[] expectedArray={0,0,0};
        int start = 10;
        int d1=0;
        int d2=0;
        FindReachableNumbers numbers = new FindReachableNumbers();
        assertArrayEquals(expectedArray,numbers.findReachableNumbers(inputArray,start,d1,d2));
    }
    @Test
    public void findReachableNumbersThree() {
        int[] inputArray=null;
        int[] expectedArray={1,0,1};
        int start = 10;
        int d1=4;
        int d2=6;
        FindReachableNumbers numbers = new FindReachableNumbers();
        assertNull(numbers.findReachableNumbers(inputArray,start,d1,d2));
    }
    @Test
    public void findReachableNumbersFour() {
        int[] inputArray={10,15,20};
        int[] expectedArray={1,1,1};
        int start = 10;
        int d1=4;
        int d2=9;
        FindReachableNumbers numbers = new FindReachableNumbers();
        assertArrayEquals(expectedArray,numbers.findReachableNumbers(inputArray,start,d1,d2));
    }

    @Test
    public void findReachableNumbersFive() {
        int[] inputArray={10,15,20};
        int[] expectedArray={0,1,0};
        int start = 15;
        int d1=4;
        int d2=6;
        FindReachableNumbers numbers = new FindReachableNumbers();
        assertArrayEquals(expectedArray,numbers.findReachableNumbers(inputArray,start,d1,d2));
    }


    @Test
    public void calculateGcd() {
    }
}